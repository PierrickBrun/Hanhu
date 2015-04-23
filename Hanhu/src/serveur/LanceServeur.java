package serveur;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

	public static void main(String[] args) {

		// à changer selon machine
		System.setProperty("java.security.policy",
				"D:\\Users\\Pierrick_2\\gitHanhu\\Hanhu\\ma_policy_serveur");

		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			System.out.println("déjà un registre");
			// un registre RMI est déjà existant.
		}

		try {
			_Serveur serveur = new Serveur();

			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress()
					+ "/serveur";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, serveur);
			System.out.println("serveur lancé");

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
