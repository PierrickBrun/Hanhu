package action.echange;

import java.rmi.RemoteException;
import java.util.Set;

import utilisateur._Utilisateur;
import action._Envoi;

public interface _Transmission extends _Envoi {

	/**
	 * Renvoie la liste des utilisateurs
	 * @return liste des utilisateurs de la discussion
	 * @throws RemoteException
	 */
	public Set<_Utilisateur> utilisateurs() throws RemoteException;
	
	

}
