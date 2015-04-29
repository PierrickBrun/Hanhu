package stockage;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import utilisateur.Utilisateur;
import utilisateur._Utilisateur;

public class StockageZone extends UnicastRemoteObject implements _Stockage {

	private static final long serialVersionUID = -9207428016786805220L;
	private String nom;
	private String adresse;
	private LinkedList<_Utilisateur> ListUsers = new LinkedList<_Utilisateur>();
	
	/**
	 * Constructeur de la zone
	 * @param nom
	 * @param user
	 * @throws RemoteException
	 */
	protected StockageZone(String nom, Utilisateur user, String adresse) throws RemoteException {
		super();
		this.nom = nom;
		this.adresse = adresse;
		File dir = new File(adresse + this.nom);
		dir.mkdirs();
		ListUsers.add(user);
	}
	
	@Override
	public void setAcces(boolean autorisation, _Utilisateur user)
			throws RemoteException {
		if (autorisation) {
			ListUsers.add(user);
		} else
			ListUsers.remove(user);
	}

	@Override
	public String adresse() throws RemoteException {return adresse;}

	@Override
	public String nom() throws RemoteException {return nom;}

}
