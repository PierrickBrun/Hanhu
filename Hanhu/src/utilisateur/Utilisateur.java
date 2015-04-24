package utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Utilisateur extends UnicastRemoteObject implements
		_Utilisateur {

	private static final long serialVersionUID = -1174373080946025077L;

	protected Utilisateur() throws RemoteException {
		super();
	}

	public abstract boolean checkPass(String pass);

	public abstract String pseudo();

}
