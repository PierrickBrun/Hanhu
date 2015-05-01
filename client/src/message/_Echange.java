package message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import utilisateur._Utilisateur;

public interface _Echange extends Remote {

	/**
	 * renvoie tous les messages de l'echange
	 * 
	 * @return list de message
	 */
	public List<_Message> messages() throws RemoteException;

	/**
	 * renvoie tous les messages de l'echange recus apres la date donnee
	 * 
	 * @param date
	 * @return
	 */
	public List<_Message> messages(Date date) throws RemoteException;

	/**
	 * renvoie la liste d'utilisateurs de l'échange	 * 
	 * @return liste utilisateur
	 */
	public Set<_Utilisateur> utilisateurs() throws RemoteException;

	/**
	 * ajout un message à la liste
	 * @param message
	 */
	public void addMessage(_Message message) throws RemoteException;

	/**
	 * Ajoutel'utilisateur
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	/**
	 * Supprime l'utilisateur
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException;

}
