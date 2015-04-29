package action.echange;

import java.rmi.RemoteException;
import java.util.Set;

import message._Message;
import utilisateur._Utilisateur;

public interface _Discussion extends _Synchrone, _Transmission {
	
	/**
	 * Ajoute un utilisateur à la liste des utilisateurs de la discussion
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException;
	
	/**
	 * Supprime l'utilisateur de la liste des utilisateurs de la discussion
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	@Override
	public void envoyer(_Message message) throws RemoteException;

	@Override
	public Object recevoir() throws RemoteException;
	
	/**
	 * Renvoie la liste des utilisateurs de la discussion
	 * @return liste des utilisateurs de la discussion
	 * @throws RemoteException
	 */
	public Set<_Utilisateur> utilisateurs() throws RemoteException;

}
