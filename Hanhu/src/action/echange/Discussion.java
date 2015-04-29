package action.echange;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import message.*;
import utilisateur.*;

public class Discussion extends UnicastRemoteObject implements _Discussion {

	private static final long serialVersionUID = 3997108109331074580L;
	private Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
	private LinkedList<_Message> messages = new LinkedList<_Message>();

	public Discussion(Set<_Utilisateur> users) throws RemoteException {
		this.utilisateurs = users;
	}

	public Discussion() throws RemoteException {
	}

	@Override
	public Set<_Utilisateur> utilisateurs() {
		return utilisateurs;
	}

	@Override
	public void addUtilisateur(_Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	@Override
	public void delUtilisateur(_Utilisateur utilisateur) {
		utilisateurs.remove(utilisateur);
	}

	@Override
	public void envoyer(_Message message) throws RemoteException {
		messages.add(message);
	}

	@Override
	public Object recevoir() throws RemoteException {

		return messages;

	}
}
