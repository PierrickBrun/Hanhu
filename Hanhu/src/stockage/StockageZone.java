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
	private LinkedList<_Utilisateur> ListUsers = new LinkedList<_Utilisateur>();

	protected StockageZone(String nom, Utilisateur user) throws RemoteException {
		super();
		this.nom = nom;
		File dir = new File("outuveuxrecevoir" + this.nom);
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

}
