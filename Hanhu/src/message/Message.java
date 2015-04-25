package message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import utilisateur._Utilisateur;

public class Message extends UnicastRemoteObject implements _Message {

	private static final long serialVersionUID = -5111433680694909273L;
	private _Utilisateur expediteur;
	private Object objet;
	private Date date;

	public Message(_Utilisateur expediteur, Object objet)
			throws RemoteException {
		this.expediteur = expediteur;
		this.objet = objet;
		this.date = new Date();
	}

	public Date date() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public _Utilisateur expediteur() {
		return expediteur;
	}

	public Object objet() {
		return objet;
	}

}
