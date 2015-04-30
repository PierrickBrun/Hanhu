package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import message._Echange;
import message._Message;

public class Asynchrone extends UnicastRemoteObject implements _Asynchrone {

	private static final long serialVersionUID = -2320000314548384466L;
	private List<_Message> reponse = new LinkedList<_Message>();
	private _Echange echange;

	/**
	 * Constructeur d'Asynchrone
	 * 
	 * @param serveur
	 * @throws RemoteException
	 */
	public Asynchrone(_Echange echange) throws RemoteException {
		this.echange = echange;
	}

	@Override
	public List<_Message> recevoir() {
		return reponse;
	}

	@Override
	public List<_Message> recevoir(Date date) throws RemoteException {
		List<_Message> nouveauxMessages = new LinkedList<_Message>();
		for (_Message message : reponse) {
			if (message.date().after(date)) {
				nouveauxMessages.add(message);
			}
		}
		return nouveauxMessages;
	}

	@Override
	public void envoyer(_Message message) throws RemoteException {
		if (echange.utilisateurs().contains(message.expediteur())) {
			reponse = echange.messages(message.date());
		}
	}

}
