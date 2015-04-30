package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.Set;

import message.*;
import utilisateur.*;

public class Discussion extends UnicastRemoteObject implements _Discussion {

	private static final long serialVersionUID = 3997108109331074580L;
	private _Echange echange;

	/**
	 * Constructeur de la discussion
	 * 
	 * @param users
	 * @throws RemoteException
	 */
	public Discussion(_Echange echange) throws RemoteException {
		this.echange = echange;
	}

	@Override
	public void envoyer(_Message message) throws RemoteException {
		echange.addMessage(message);
	}

	@Override
	public List<_Message> recevoir() throws RemoteException {
		return echange.messages();
	}

	@Override
	public List<_Message> recevoir(Date date) throws RemoteException {
		return echange.messages(date);
	}

	@Override
	public Set<_Utilisateur> utilisateurs() throws RemoteException {
		return echange.utilisateurs();
	}

	@Override
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		echange.addUtilisateur(utilisateur);
	}

	@Override
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		echange.delUtilisateur(utilisateur);
	}
}
