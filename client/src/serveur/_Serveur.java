package serveur;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import client._Client;
import action.echange.*;
import message.*;
import stockage._StockageZone;
import utilisateur.*;

public interface _Serveur extends Remote {

	/**
	 * connecte un utilisateur anonymement
	 * 
	 * @param client
	 *            le client qui se connecte
	 * @return utilisateur anonyme cree
	 * @throws RemoteException
	 */
	public _Utilisateur connexion(_Client client) throws RemoteException;

	/**
	 * connecte un utilisateur enregistre
	 * 
	 * @param pseudo
	 *            son pseudo
	 * @param pass
	 *            son pass
	 * @param client
	 *            le client qui se connecte
	 * @return l'utilisateur ou null si non existant ou mauvais pass
	 * @throws RemoteException
	 */
	public _Utilisateur connexion(String pseudo, String pass, _Client client)
			throws RemoteException;

	/**
	 * Cree un nouvel utilisateur
	 * 
	 * @param pseudo
	 *            son pseudo
	 * @param pass
	 *            son pass
	 * @return un nouvel utilisateur inscrit
	 * @throws RemoteException
	 */
	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException;

	/**
	 * Cree un nouveau message
	 * 
	 * @param objet
	 *            ce qui est envoyé
	 * @param expediteur
	 *            l'utilisateur qui envoie le message
	 * @return message le message créé
	 * @throws RemoteException
	 */
	public _Message nouvMessage(Object objet, _Utilisateur expediteur)
			throws RemoteException;

	/**
	 * Renvoie l'utilisateur suivant le pseudo passe en parametre
	 * 
	 * @param name
	 *            le pseudo
	 * @return utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur getUtilisateur(String name) throws RemoteException;

	/**
	 * Renvoie la liste des utilisteurs
	 * 
	 * @return utilisateurs
	 * @throws RemoteException
	 */
	public Set<_Utilisateur> utilisateurs() throws RemoteException;

	/**
	 * Renvoie l'echange entre les utilisateurs et le cree si il n'existe pas
	 * 
	 * @param utilisateurs
	 *            la liste d'utilisateurs
	 * @return echange
	 * @throws RemoteException
	 */
	public _Echange echange(Set<_Utilisateur> utilisateurs)
			throws RemoteException;

	/**
	 * Renvoie la reception asynchrone
	 * 
	 * @param echange
	 * @return reception asynchrone
	 * @throws RemoteException
	 */
	public _Asynchrone nouvAsynchrone(_Echange echange) throws RemoteException;

	/**
	 * Renvoie la reception synchrone
	 * 
	 * @param echange
	 * @return reception synchrone
	 * @throws RemoteException
	 */
	public _Synchrone nouvSynchrone(_Echange echange) throws RemoteException;

	/**
	 * Renvoie la discussion
	 * 
	 * @param echange
	 * @return discussion
	 * @throws RemoteException
	 */
	public _Discussion nouvDiscussion(_Echange echange) throws RemoteException;

	/**
	 * Renvoie la diffusion
	 * 
	 * @param echange
	 * @return diffusion
	 * @throws RemoteException
	 */
	public _Diffusion nouvDiffusion(_Echange echange) throws RemoteException;

	/**
	 * Envoie un fichier dans une zone specifique du serveur
	 * 
	 * @param fichier
	 * @param zone
	 * @throws RemoteException
	 */
	public void uploadFile(File fichier, _StockageZone zone)
			throws RemoteException;

	/**
	 * Renvoie le fichier de la zone choisie possedant le nom spécifié
	 * 
	 * @param fichier
	 *            nom du fichier
	 * @param zone
	 * @return fichier
	 * @throws RemoteException
	 */
	public File downloadFile(String fichier, _StockageZone zone)
			throws RemoteException;

	/**
	 * Renvoi la zone du serveur
	 * 
	 * @return zone
	 * @throws RemoteException
	 */
	public _StockageZone getZone() throws RemoteException;

}
