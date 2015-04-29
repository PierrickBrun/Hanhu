package utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client._Client;

public abstract class Utilisateur extends UnicastRemoteObject implements
		_Utilisateur {

	private _Client client;

	public _Client client() {
		return client;
	}

	public void setClient(_Client client2) {
		this.client = client2;
	}

	private static final long serialVersionUID = -1174373080946025077L;

	protected Utilisateur() throws RemoteException {
		super();
	}

	public abstract boolean checkPass(String pass);

	public abstract String pseudo();

	public void afficher(String message) throws RemoteException {
		client.afficher(message);
	}

}
