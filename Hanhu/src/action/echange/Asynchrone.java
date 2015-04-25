package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import serveur._Serveur;
import utilisateur._Utilisateur;

public class Asynchrone extends UnicastRemoteObject implements _Asynchrone {

	private static final long serialVersionUID = -2320000314548384466L;
	private _Serveur serveur;
	private Object reponse;

	public Asynchrone(_Serveur serveur) throws RemoteException {
		this.serveur = serveur;
	}

	@Override
	public Object recevoir() {
		return reponse;

	}

	@Override
	public void envoyer(Object objet, _Utilisateur expediteur)
			throws RemoteException {
		reponse = serveur.getList((String) objet, expediteur);
	}

}
