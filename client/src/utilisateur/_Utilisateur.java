package utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

public interface _Utilisateur extends Remote {
	
	/**
	 * Verifie le mot de passe de l'utilisateur
	 * @param
	 */
	public boolean checkPass(String pass) throws RemoteException;

	/**
	 * Renvoie le pseudo
	 * @return pseudo
	 */
	public String pseudo() throws RemoteException;
	
	/**
	 * Affiche un message
	 * @param message
	 * @throws RemoteException
	 */
	public void afficher(String message) throws RemoteException;

	/**
	 * Modifie le client
	 * @param client
	 */
	public void setClient(_Client client) throws RemoteException;
	
	/**
	 * Renvoie le client de l'utilisateur
	 * @return client
	 */
	public _Client client() throws RemoteException;

}
