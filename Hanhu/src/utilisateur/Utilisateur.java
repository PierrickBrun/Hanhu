package utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import message._Message;
import client._Client;

public abstract class Utilisateur extends UnicastRemoteObject implements
		_Utilisateur {

	private static final long serialVersionUID = -1174373080946025077L;
	protected _Client client;

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

	@Override
	public boolean connecte() throws RemoteException {
		return this.client != null;
	}

	@Override
	public void afficher(_Message message) throws RemoteException {
		this.client.afficher(message);
	}

	@Override
	public void afficher(String texte) throws RemoteException {
		if (this.client != null)
			this.client.afficher(texte);
	}

}
