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
	 * @throws RemoteException
	 */
	public List<_Message> messages() throws RemoteException;

	/**
	 * renvoie tous les messages de l'echange recus apres la date donnee
	 * 
	 * @param date
	 * @return list de message
	 * @throws RemoteException
	 */
	public List<_Message> messages(Date date) throws RemoteException;

	/**
	 * renvoie la liste d'utilisateurs de l'echange
	 * 
	 * @return liste utilisateur
	 * @throws RemoteException
	 */
	public Set<_Utilisateur> utilisateurs() throws RemoteException;

	/**
	 * ajoute un message a la liste et le diffuse si l'�change st en mode
	 * diffusion
	 * 
	 * @param message
	 * @throws RemoteException
	 */
	public void addMessage(_Message message) throws RemoteException;

	/**
	 * Ajoute l'utilisateur
	 * 
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	/**
	 * Supprime l'utilisateur
	 * 
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	/**
	 * ajoute un message et le diffuse si diffusion est vrai
	 * 
	 * @param message
	 * @param diffusion
	 * @throws RemoteException
	 */
	public void addMessage(_Message message, boolean diffusion)
			throws RemoteException;

	/**
	 * affiche le message � tous les utilisateurs
	 * 
	 * @param message
	 * @throws RemoteException
	 */
	public void diffuser(_Message message) throws RemoteException;

	/**
	 * 
	 * @return diffusion
	 * @throws RemoteException
	 */
	public boolean isDiffusion() throws RemoteException;

	/**
	 * change le mode de diffusion
	 * 
	 * @param diffusion
	 * @throws RemoteException
	 */
	public void setDiffusion(boolean diffusion) throws RemoteException;

}
