package utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client._Client;

public interface _Utilisateur extends Remote {

	/**
	 * Renvoi true si l'utilisateur est connecte sinon false
	 * 
	 * @return connecte
	 * @throws RemoteException
	 */
	public boolean connecte() throws RemoteException;

	/**
	 * Modifie la valeur de connecte
	 * 
	 * @param connecte
	 * @throws RemoteException
	 */
	public void setConnecte(boolean connecte) throws RemoteException;

	/**
	 * Verifie le mot de passe de l'utilisateur
	 * 
	 * @param pass
	 *            le pass
	 * @return true si bon mdp, false si mauvais mdp
	 * @throws RemoteException
	 */
	public boolean checkPass(String pass) throws RemoteException;

	/**
	 * Renvoie le pseudo
	 * 
	 * @return pseudo
	 * @throws RemoteException
	 */
	public String pseudo() throws RemoteException;

	/**
	 * Modifie le client
	 * 
	 * @param client
	 * @throws RemoteException
	 */
	public void setClient(_Client client) throws RemoteException;

	/**
	 * Renvoie le client de l'utilisateur
	 * 
	 * @return client
	 * @throws RemoteException
	 */
	public _Client client() throws RemoteException;

}
