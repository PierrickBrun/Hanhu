package action;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import message._Message;

public interface _Reception extends Remote {

	/**
	 * Reception d'une liste de messages
	 * 
	 * @return objet
	 * @throws RemoteException
	 */
	public List<_Message> recevoir() throws RemoteException;

	/**
	 * Reception d'un message à partir d'une date
	 * @param date
	 * @return
	 * @throws RemoteException
	 */
	public List<_Message> recevoir(Date date) throws RemoteException;

}
