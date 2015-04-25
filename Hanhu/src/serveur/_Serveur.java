package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import action.echange.*;
import message.*;
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

	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException;

	public _Diffusion nouvDiffusion() throws RemoteException;

	public void addDiffusion(_Message message) throws RemoteException;

	public Collection<_Message> getList(String name, _Utilisateur expediteur)
			throws RemoteException;

	public _Asynchrone nouvAsynchrone() throws RemoteException;

}
