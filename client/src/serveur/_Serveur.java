package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Set;

import client._Client;
import action.echange.*;
import message.*;
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
	public _Utilisateur connexion(String pseudo, String pass, _Client client) throws RemoteException;

	/**
	 * Cree un nouvel utilisateur
	 * @param pseudo
	 * @param pass
	 * @return un utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur nouvUtilisateur(String pseudo, String pass) throws RemoteException;

	/**
	 * Cree une nouvelle discussion
	 * @return une discussion
	 * @throws RemoteException
	 */
	public _Diffusion nouvDiffusion() throws RemoteException;
	
	/**
	 * Modifie la liste des utilisateurs de la discussion
	 * @param utilisateurs
	 * @return discussion 
	 * @throws RemoteException
	 */
	public _Discussion discussion(Set<_Utilisateur> utilisateurs) throws RemoteException;

	/**
	 * Cree un nouveau message
	 * @param objet
	 * @param expediteur
	 * @return message
	 * @throws RemoteException
	 */
	public _Message nouvMessage(Object objet, _Utilisateur expediteur) throws RemoteException;

	/**
	 * Ajout un message à la diffusion
	 * @param message
	 * @throws RemoteException
	 */
	public void addDiffusion(_Message message) throws RemoteException;

	/**
	 * Renvoie la diffusion
	 * @param name
	 * @param expediteur
	 * @return
	 * @throws RemoteException
	 */
	public Collection<_Message> getList(String name, _Utilisateur expediteur) throws RemoteException;

	/**
	 * Cree une reception asynchrone
	 * @return la reception
	 * @throws RemoteException
	 */
	public _Asynchrone nouvAsynchrone() throws RemoteException;

	/**
	 * Envoi un fichier 
	 * @param adresse
	 * @throws RemoteException
	 */
	public void uploadFile(String nom, String adresse) throws RemoteException;

	/**
	 * Reception d'un fichier
	 * @param nom
	 * @param adresse
	 * @throws RemoteException
	 */
	public void downloadFile(String nom, String adresse) throws RemoteException;

	/**
	 * Renvoie l'utilisateur suivant le pseudo passe en parametre
	 * @param name
	 * @return utilisateur
	 * @throws RemoteException
	 */
	public _Utilisateur getUtilisateur(String name) throws RemoteException;

	/**
	 * Cree un nouveau Client 
	 * @return client
	 * @throws RemoteException
	 */
	public _Client nouvClient() throws RemoteException;

}
