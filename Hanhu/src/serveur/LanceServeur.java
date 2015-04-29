package serveur;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Scanner;

public class LanceServeur {

	public static void main(String[] args) {

		System.setProperty("java.security.policy", "src/server.policy");

		System.setProperty("rmi.server.codebase", "bin/");

		try {

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}

			LocateRegistry.createRegistry(1099);
			_Serveur serveur = new Serveur();

			String url = "rmi://" + Ip();
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url + "/serveur", serveur);
			System.out.println("serveur lancé");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String Ip() throws SocketException {
		HashSet<String> adresses = new HashSet<String>();
		Enumeration<NetworkInterface> e = NetworkInterface
				.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			Enumeration<InetAddress> i = e.nextElement().getInetAddresses();
			while (i.hasMoreElements()) {
				InetAddress a = i.nextElement();
				if (a instanceof Inet4Address && !a.isLoopbackAddress()) {
					adresses.add(a.getHostAddress());
				}
			}
		}
		for (String adresse : adresses) {
			if (adresses.size() == 1) {
				return adresse;
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("se connecter avec : " + adresse + " ? (o/n)");
			String choix = sc.nextLine();
			sc.close();
			if (choix.equals("o")) {
				return adresse;
			}
		}
		return null;
	}
}
