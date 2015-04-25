package message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import utilisateur._Utilisateur;

public interface _Message extends Remote {

	public Date date() throws RemoteException;

	public void setDate(Date date) throws RemoteException;

	public _Utilisateur expediteur() throws RemoteException;

	public Object objet() throws RemoteException;
}
