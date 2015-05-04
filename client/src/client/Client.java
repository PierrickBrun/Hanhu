package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import message._Message;
import serveur._Serveur;
import utilisateur._Utilisateur;

public class Client extends UnicastRemoteObject implements _Client {

	protected _Utilisateur utilisateur;
	protected _Serveur serveur;

	private static final long serialVersionUID = -8573239739135421784L;

	/**
	 * Constructeur du Client
	 * 
	 * @param serveur
	 * @throws RemoteException
	 */
	public Client(_Serveur serveur) throws RemoteException {
		super();
		this.serveur = serveur;
	}

	@Override
	public _Utilisateur connexion() throws RemoteException {
		utilisateur = serveur.connexion(this);
		return utilisateur;
	}

	@Override
	public _Utilisateur connexion(String pseudo, String pass)
			throws RemoteException {
		utilisateur = serveur.connexion(pseudo, pass, this);
		return utilisateur;
	}

	@Override
	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException {
		serveur.nouvUtilisateur(pseudo, pass);
		utilisateur = serveur.connexion(pseudo, pass, this);
		return utilisateur;
	}

	@Override
	public _Utilisateur utilisateur() {
		return utilisateur;
	}

	@Override
	public _Serveur serveur() {
		return serveur;
	}

	@Override
	public void afficher(String texte) {
		System.out.println(texte);
	}

	@Override
	public void afficher(_Message message) throws RemoteException {
		System.out.println(message.date() + "   "
				+ message.expediteur().pseudo() + "   " + message.objet());
	}

	@Override
	public void deconnexion() throws RemoteException {
		this.utilisateur.setClient(null);
		try {
			finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}