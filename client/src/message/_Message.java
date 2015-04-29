package message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import utilisateur._Utilisateur;

public interface _Message extends Remote {
	
	/**
	 * Renvoie la date du message
	 * @return date
	 * @throws RemoteException
	 */
	public Date date() throws RemoteException;
	
	/**
	 * Modifie la date du message
	 * @param date
	 * @throws RemoteException
	 */
	public void setDate(Date date) throws RemoteException;
	/**
	 * Renvoie l'utilisateur expediteur du message
	 * @return
	 * @throws RemoteException
	 */
	public _Utilisateur expediteur() throws RemoteException;
	
	/**
	 * Renvoie l'objet du message
	 * @return objet
	 * @throws RemoteException
	 */
	public Object objet() throws RemoteException;

}
