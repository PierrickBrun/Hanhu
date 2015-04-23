package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import utilisateur.*;

@SuppressWarnings("serial")
public class Serveur extends UnicastRemoteObject implements _Serveur {

	protected Serveur() throws RemoteException {
		super();
	}

	// private Set<Stockage> stockages;
	private Set<Utilisateur> utilisateurs;

	/**
	 * connecte un utilisateur anonymement, cr�� � la vol�e
	 * 
	 * @return utilisateur cr��
	 */
	public Utilisateur connexion() {
		System.out.println("OKLM");
		Anonyme anonyme = new Anonyme();
		return anonyme;
	}

	/**
	 * connecte un utilisateur enregistr�
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public Utilisateur connexion(String pseudo, String pass) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.pseudo().equals(pseudo)) {
				if (utilisateur.checkPass(pass)) {
					return utilisateur;
				}
			}
		}
		return null;
	}

}