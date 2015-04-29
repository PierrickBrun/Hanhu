package action.echange;

import java.rmi.RemoteException;
import java.util.Set;

import message._Message;
import utilisateur._Utilisateur;

public interface _Discussion extends _Synchrone, _Transmission {

	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException;

	@Override
	public void envoyer(_Message message) throws RemoteException;

	@Override
	public Object recevoir() throws RemoteException;

	public Set<_Utilisateur> utilisateurs() throws RemoteException;

}
