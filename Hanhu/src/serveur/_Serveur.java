package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utilisateur.*;

public interface _Serveur extends Remote {

	/**
	 * connecte un utilisateur anonymement, créé à la volée
	 * 
	 * @return utilisateur créé
	 */
	public _Utilisateur connexion() throws RemoteException;

	/**
	 * connecte un utilisateur enregistré
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public _Utilisateur connexion(String pseudo, String pass)
			throws RemoteException;

	public _Utilisateur nouvelUtilisateur(String pseudo, String pass)
			throws RemoteException;

}
