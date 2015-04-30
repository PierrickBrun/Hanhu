package action;

import java.rmi.Remote;
import java.rmi.RemoteException;

import message._Message;

public interface _Envoi extends Remote {

	/**
	 * Envoie une donnee de type message
	 * 
	 * @param message
	 * @throws RemoteException
	 */
	public void envoyer(_Message message) throws RemoteException;
}
