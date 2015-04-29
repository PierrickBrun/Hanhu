package client;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import message._Message;
import action.echange.*;
import serveur._Serveur;
import utilisateur._Utilisateur;

public class LanceClient {

	public LanceClient() throws RemoteException {
		super();

	}

	public static void main(String[] args) {

		System.setProperty("java.security.policy",
				"${workspace_loc:client}/client/src/client.policy");

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer l'url du serveur :");
			String url = sc.nextLine();
			sc.close();
			Remote remote = Naming.lookup("rmi://" + url + "/serveur");
			if (remote instanceof _Serveur) {
				_Serveur serveur = (_Serveur) remote;
				_Client client = serveur.nouvClient();
				client.connexion();
				System.out.println(client.utilisateur().pseudo());

				Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
				utilisateurs.add(client.utilisateur());
				Thread.sleep(10000);
				utilisateurs.add(serveur.getUtilisateur("guest1"));
				System.out.println(utilisateurs.size());
				_Discussion discussion = serveur.discussion(utilisateurs);
				int continuer = 1;
				while (continuer == 1) {
					Thread.sleep(2000);
					System.out.println("Ecrire : ");
					_Message message = serveur.nouvMessage(
							"salut fatoumata tamaté", client.utilisateur());
					discussion.envoyer(message);
					List<_Message> lecture = (List<_Message>) discussion
							.recevoir();
					for (_Message messageRecu : lecture) {
						System.out.println("[" + messageRecu.date() + "] "
								+ messageRecu.expediteur().pseudo() + " : "
								+ messageRecu.objet());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}