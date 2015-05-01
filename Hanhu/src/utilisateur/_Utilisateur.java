package utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

public interface _Utilisateur extends Remote {

	/**
	 * Renvoi true si l'utilisateur et connecte sinon false
	 * @return connecte
	 * @throws RemoteException
	 */
	public boolean connecte() throws RemoteException;
	
	/**
	 * Modifie la valeur de connecte
	 * @param connecte
	 * @throws RemoteException
	 */
	public void setConnecte(boolean connecte) throws RemoteException;
	/**
	 * Verifie le mot de passe de l'utilisateur
	 * 
	 * @param
	 */
	public boolean checkPass(String pass) throws RemoteException;

	/**
	 * Renvoie le pseudo
	 * 
	 * @return pseudo
	 */
	public String pseudo() throws RemoteException;

	/**
	 * Affiche un message
	 * 
	 * @param message
	 * @throws RemoteException
	 */
	public void afficher(String message) throws RemoteException;

	/**
	 * Modifie le client
	 * 
	 * @param client
	 */
	public void setClient(_Client client) throws RemoteException;

	/**
	 * Renvoie le client de l'utilisateur
	 * 
	 * @return client
	 */
	public _Client client() throws RemoteException;

}
