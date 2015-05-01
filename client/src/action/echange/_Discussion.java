package action.echange;

import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _Discussion extends _Synchrone, _Diffusion {

	/**
	 * Ajoute un utilisateur à la liste des utilisateurs de la discussion
	 * 
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	/**
	 * Supprime l'utilisateur de la liste des utilisateurs de la discussion
	 * 
	 * @param utilisateur
	 * @throws RemoteException
	 */
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException;

}
