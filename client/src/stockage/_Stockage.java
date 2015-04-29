package stockage;

import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _Stockage {

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
}
