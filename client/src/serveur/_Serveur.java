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
	 * @return utilisateur cree
	 */
	public _Utilisateur connexion(_Client client) throws RemoteException;

	/**
	 * connecte un utilisateur enregistre
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public _Utilisateur connexion(String pseudo, String pass, _Client client)
			throws RemoteException;

	/**
	 * Cree un nouvel utilisateur
	 * 
	 * @param pseudo
	 * @param pass
	 * @return un utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException;

	/**
	 * Cree un nouveau message
	 * 
	 * @param objet
	 * @param expediteur
	 * @return message
	 * @throws RemoteException
	 */
	public _Message nouvMessage(Object objet, _Utilisateur expediteur)
			throws RemoteException;

	/**
	 * Renvoie l'utilisateur suivant le pseudo passe en parametre
	 * 
	 * @param name
	 * @return utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur getUtilisateur(String name) throws RemoteException;

	/**
	 * Cree un nouveau Client
	 * 
	 * @return client
	 * @throws RemoteException
	 */
	public _Client nouvClient() throws RemoteException;

	public Set<_Utilisateur> utilisateurs() throws RemoteException;

	public _Echange echange(Set<_Utilisateur> utilisateurs)
			throws RemoteException;

	public _Asynchrone nouvAsynchrone(_Echange echange) throws RemoteException;

	public _Synchrone nouvSynchrone(_Echange echange) throws RemoteException;

	public _Discussion nouvDiscussion(_Echange echange) throws RemoteException;

	public _Diffusion nouvDiffusion(_Echange echange) throws RemoteException;

	public void uploadFile(File fichier, _StockageZone zone)
			throws RemoteException;

	public void downloadFile(String fichier, _StockageZone zone,
			String reception) throws RemoteException;

	public _StockageZone getZone() throws RemoteException;

}
