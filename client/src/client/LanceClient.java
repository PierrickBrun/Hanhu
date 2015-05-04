package client;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import message.*;
import action.echange.*;
import serveur._Serveur;
import utilisateur._Utilisateur;

public class LanceClient {

	public LanceClient() throws RemoteException {
		super();

	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer l'url du serveur :");
			String url = sc.nextLine();
			sc.close();
			Remote remote = Naming.lookup("rmi://" + url + "/serveur");
			if (remote instanceof _Serveur) {
				_Serveur serveur = (_Serveur) remote;
				_Client client = new Client(serveur);
				client.connexion();
				System.out.println(client.utilisateur().pseudo());

				Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
				utilisateurs.add(client.utilisateur());
				Thread.sleep(10000);
				utilisateurs.add(serveur.getUtilisateur("guest0"));
				System.out.println(utilisateurs.size());
				_Echange echange = serveur.echange(utilisateurs);
				echange.setDiffusion(true);
				_Discussion discussion = serveur.nouvDiscussion(echange);
				int continuer = 1;

				while (continuer == 1) {
					_Message message = serveur.nouvMessage("mdr",
							client.utilisateur());
					discussion.envoyer(message);
					Thread.sleep(2000);
					/**
					 * List<_Message> lecture = (List<_Message>) discussion
					 * .recevoir(message.date());
					 * 
					 * for (_Message messageRecu : lecture) {
					 * System.out.println("[" + messageRecu.date() + "] " +
					 * messageRecu.expediteur().pseudo() + " : " +
					 * messageRecu.objet()); }
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}