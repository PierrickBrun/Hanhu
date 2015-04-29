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
	
	/**
	 * Constructeur du message
	 * @param expediteur
	 * @param objet
	 * @throws RemoteException
	 */
	public Message(_Utilisateur expediteur, Object objet)
			throws RemoteException {
		this.expediteur = expediteur;
		this.objet = objet;
		this.date = new Date();
	}
	
	@Override
	public Date date() {return date;}
	
	@Override
	public void setDate(Date date) {this.date = date;}
	
	@Override
	public _Utilisateur expediteur() {return expediteur;}
	
	@Override
	public Object objet() {return objet;}

}
