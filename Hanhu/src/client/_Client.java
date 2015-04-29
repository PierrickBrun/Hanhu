package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import serveur._Serveur;
import utilisateur._Utilisateur;

public interface _Client extends Remote {
	
	/**
	 * Affiche le message donner en paramètre sous le format attendu
	 * @param texte
	 * @throws RemoteException
	 */
	public void afficher(String texte) throws RemoteException;
	/**
	 * Connecte un client suivant les identifiants de l'utilisateur entre en paramètre
	 * @param pseudo
	 * @param pass
	 * @param client
	 * @return l'utilisateur existante sur le serveur
	 * @throws RemoteException
	 */
	public _Utilisateur connexion(String pseudo, String pass, _Client client) throws RemoteException;
	/**
	 * Connecte un client anonyme
	 * @return l'utilisateur anonyme
	 * @throws RemoteException
	 */
	public _Utilisateur connexion() throws RemoteException;
	
	/**
	 * Renvoie l'utilisateur
	 * @return utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur utilisateur() throws RemoteException;
	
	/**
	 * Renvoi le serveur
	 * @return serveur
	 * @throws RemoteException
	 */
	public _Serveur serveur() throws RemoteException;

}
