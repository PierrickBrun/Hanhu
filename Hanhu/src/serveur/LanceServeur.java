package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

	public static void main(String[] args) {

		/*
		 * System.setProperty("java.security.policy",
		 * "D:\\Users\\Pierrick_2\\gitHanhu\\Hanhu\\server.policy");
		 */

		try {
			/*
			 * if (System.getSecurityManager() == null) {
			 * System.setSecurityManager(new SecurityManager()); }
			 */
			LocateRegistry.createRegistry(1099);
			_Serveur serveur = new Serveur();

			String url = "rmi://" + "152.77.82.242";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url + "/serveur", serveur);
			System.out.println("serveur lancé");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
