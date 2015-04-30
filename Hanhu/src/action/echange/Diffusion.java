package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import message.*;
import serveur.*;
import utilisateur._Utilisateur;

public class Diffusion extends UnicastRemoteObject implements _Diffusion {

	private static final long serialVersionUID = 8107562705972843126L;
	protected _Echange echange;

	/**
	 * Constructeur de la Diffusion
	 * 
	 * @param serveur
	 * @throws RemoteException
	 */
	public Diffusion(_Echange echange) throws RemoteException {
		this.echange = echange;
	}

	public Diffusion(_Serveur serveur) throws RemoteException {
		this.echange = new Echange(serveur.utilisateurs());
	}

	@Override
	public Set<_Utilisateur> utilisateurs() throws RemoteException {
		return echange.utilisateurs();
	}

	@Override
	public void envoyer(_Message message) throws RemoteException {
		echange.addMessage(message);
	}

}
