package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import message.*;
import serveur.*;
import utilisateur._Utilisateur;

public class Diffusion extends UnicastRemoteObject implements _Diffusion {

	private static final long serialVersionUID = 8107562705972843126L;
	private Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
	private LinkedList<_Message> messages = new LinkedList<_Message>();

	/**
	 * Constructeur de la Diffusion
	 * 
	 * @param serveur
	 * @throws RemoteException
	 */
	public Diffusion(Set<_Utilisateur> utilisateurs) throws RemoteException {
		this.utilisateurs = utilisateurs;
	}

	public Diffusion(_Serveur serveur) throws RemoteException {
		this.utilisateurs = serveur.utilisateurs();
	}

	@Override
	public Set<_Utilisateur> utilisateurs() {
		return utilisateurs;
	}

	@Override
	public void envoyer(_Message message) throws RemoteException {
		messages.add(message);
	}

}
