package stockage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import utilisateur.Utilisateur;
import utilisateur._Utilisateur;

public class StockageFichier extends UnicastRemoteObject implements _Stockage {

	private static final long serialVersionUID = 531750329738065221L;
	private String nom;
	private StockageZone zone;
	private LinkedList<_Utilisateur> ListUsers = new LinkedList<_Utilisateur>();

	protected StockageFichier(String nom, StockageZone zone, Utilisateur user)
			throws RemoteException {
		super();
		this.nom = nom;
		this.zone = zone;
		this.ListUsers.add(user);
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
