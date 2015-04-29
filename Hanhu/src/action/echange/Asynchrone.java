package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import message._Message;
import serveur._Serveur;

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
	public void envoyer(_Message message) throws RemoteException {
		reponse = serveur.getList((String) message.objet(),
				message.expediteur());
	}

}
