package action;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Reception extends Remote {

	/**
	 * Reception d'un objet
	 * @return objet
	 * @throws RemoteException
	 */
	public Object recevoir() throws RemoteException;

}
