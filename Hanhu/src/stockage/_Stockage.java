package stockage;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _Stockage extends Remote{

	/**
	 * Modifie la liste des personnes ayant un accès au fichier/dossier
	 * @param autorisation
	 * @param user
	 * @throws RemoteException
	 */
	public void setAcces(boolean autorisation, _Utilisateur user) throws RemoteException;
	
	/**
	 * Renvoie l'adresse du fichier/dossier
	 * @return adresse
	 * @throws RemoteException
	 */
	public String adresse() throws RemoteException;
	
	/**
	 * Renvoie le nom du fichier/dossier
	 * @return nom
	 * @throws RemoteException
	 */
	public String nom() throws RemoteException;
	
	/**
	 * Ajoute un fichier à la liste des fichiers de la zone
	 * @param fichier
	 * @throws RemoteException
	 */
	public void addFile(File fichier) throws RemoteException;
	
	/**
	 * Renvoi le fichier si son nom existe dans la liste
	 * @param nom
	 * @return
	 * @throws RemoteException
	 */
	public File fichier(String nom) throws RemoteException;
}
