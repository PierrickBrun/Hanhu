package utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

public interface _Utilisateur extends Remote {

	public boolean checkPass(String pass) throws RemoteException;

	public String pseudo() throws RemoteException;

	public void afficher(String message) throws RemoteException;

	public void setClient(_Client client) throws RemoteException;

	public _Client client() throws RemoteException;

}
