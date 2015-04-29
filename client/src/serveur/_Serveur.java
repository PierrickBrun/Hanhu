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
	 * connecte un utilisateur anonymement, cr�� � la vol�e
	 * 
	 * @return utilisateur cr��
	 */
	public _Utilisateur connexion(_Client client) throws RemoteException;

	/**
	 * connecte un utilisateur enregistr�
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public _Utilisateur connexion(String pseudo, String pass, _Client client)
			throws RemoteException;

	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException;

	public _Diffusion nouvDiffusion() throws RemoteException;

	public _Discussion discussion(Set<_Utilisateur> utilisateurs)
			throws RemoteException;

	public _Message nouvMessage(Object objet, _Utilisateur expediteur)
			throws RemoteException;

	public void addDiffusion(_Message message) throws RemoteException;

	public Collection<_Message> getList(String name, _Utilisateur expediteur)
			throws RemoteException;

	public _Asynchrone nouvAsynchrone() throws RemoteException;

	public void uploadFile(String nom, String adresse) throws RemoteException;

	public void downloadFile(String nom, String adresse) throws RemoteException;

	public _Utilisateur getUtilisateur(String name) throws RemoteException;

	public _Client nouvClient() throws RemoteException;

}
