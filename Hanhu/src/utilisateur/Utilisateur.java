package utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client._Client;

public abstract class Utilisateur extends UnicastRemoteObject implements
		_Utilisateur {

	private static final long serialVersionUID = -1174373080946025077L;
	protected _Client client;
	protected boolean connecte;

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

	public boolean equals(Utilisateur utilisateur) throws RemoteException {
		return utilisateur.pseudo().equals(this.pseudo());
	}

}
