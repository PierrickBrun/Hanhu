package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import message.*;
import serveur.*;

public class Diffusion extends UnicastRemoteObject implements _Diffusion {

	private static final long serialVersionUID = 8107562705972843126L;
	private _Serveur serveur;
	
	/**
	 * Constructeur de la Diffusion
	 * @param serveur
	 * @throws RemoteException
	 */
	public Diffusion(_Serveur serveur) throws RemoteException {
		this.serveur = serveur;
	}
	
	@Override
	public void envoyer(_Message message) throws RemoteException {
		serveur.addDiffusion(message);
	}

}
