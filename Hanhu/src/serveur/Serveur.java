package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

import utilisateur.*;

public class Serveur extends UnicastRemoteObject implements _Serveur {

	private static final long serialVersionUID = -6046874410587068537L;

	protected Serveur() throws RemoteException {
		super();
	}

	// private Set<Stockage> stockages;
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>();

	private void addUser(Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	/**
	 * connecte un utilisateur anonymement, créé à la volée
	 * 
	 * @return utilisateur créé
	 * @throws RemoteException
	 */
	public Utilisateur connexion() throws RemoteException {
		Anonyme anonyme = new Anonyme(utilisateurs.size());
		addUser(anonyme);
		return anonyme;
	}

	/**
	 * connecte un utilisateur enregistré
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

	@Override
	public _Utilisateur nouvelUtilisateur(String pseudo, String pass)
			throws RemoteException {
		Inscrit inscrit = new Inscrit(pseudo, pass);
		addUser(inscrit);
		return inscrit;
	}

}