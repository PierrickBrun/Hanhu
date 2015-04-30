package message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import utilisateur._Utilisateur;

public class Echange extends UnicastRemoteObject implements _Echange {

	private static final long serialVersionUID = 3300851989932559840L;
	protected Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
	protected LinkedList<_Message> messages = new LinkedList<_Message>();

	public Echange(Set<_Utilisateur> users) throws RemoteException {
		utilisateurs = users;
	}

	@Override
	public List<_Message> messages() {
		return messages;
	}

	@Override
	public List<_Message> messages(Date date) throws RemoteException {
		List<_Message> nouveauxMessages = new LinkedList<_Message>();
		for (_Message message : messages) {
			if (message.date().after(date)) {
				nouveauxMessages.add(message);
			}
		}
		return nouveauxMessages;
	}

	@Override
	public void addMessage(_Message message) throws RemoteException {
		message.setDate(new Date());
		messages.add(message);
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

}
