package action;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _Envoi extends Remote {

	public void envoyer(Object objet, _Utilisateur expediteur)
			throws RemoteException;
}
