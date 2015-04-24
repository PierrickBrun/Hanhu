package serveur;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

	public static void main(String[] args) {

		/*
		 * à changer selon machine System.setProperty("java.security.policy",
		 * "D:\\Users\\Pierrick_2\\gitHanhu\\Hanhu\\ma_policy_serveur");
		 */

		try {
			LocateRegistry.createRegistry(1099);
			_Serveur serveur = new Serveur();

			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress()
					+ "/serveur";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, serveur);
			System.out.println("serveur lancé");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
