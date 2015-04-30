package utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client._Client;

public abstract class Utilisateur extends UnicastRemoteObject implements
		_Utilisateur {

	private _Client client;
	private static final long serialVersionUID = -1174373080946025077L;

	@Override
	public _Client client() {
		return client;
	}

	@Override
	public void setClient(_Client client2) {
		this.client = client2;
	}

	/**
	 * Constructeur Utilisateur
	 * 
	 * @throws RemoteException
	 */
	protected Utilisateur() throws RemoteException {
		super();
	}

	@Override
	public abstract boolean checkPass(String pass);

	@Override
	public abstract String pseudo();

	@Override
	public void afficher(String message) throws RemoteException {
		client.afficher(message);
	}

	public boolean equals(Utilisateur utilisateur) throws RemoteException {
		return utilisateur.pseudo().equals(this.pseudo());
	}

}
