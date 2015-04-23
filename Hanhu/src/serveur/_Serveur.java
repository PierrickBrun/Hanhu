package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utilisateur.*;

public interface _Serveur extends Remote {

	/**
	 * connecte un utilisateur anonymement, cr�� � la vol�e
	 * 
	 * @return utilisateur cr��
	 */
	public Utilisateur connexion() throws RemoteException;

	/**
	 * connecte un utilisateur enregistr�
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public Utilisateur connexion(String pseudo, String pass) throws RemoteException;

}
