package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import serveur._Serveur;
import utilisateur._Utilisateur;

public interface _Client extends Remote {

	public void afficher(String texte) throws RemoteException;

	public _Utilisateur connexion(String pseudo, String pass, _Client client)
			throws RemoteException;

	public _Utilisateur connexion() throws RemoteException;

	public _Utilisateur utilisateur();

	public _Serveur serveur();

}
