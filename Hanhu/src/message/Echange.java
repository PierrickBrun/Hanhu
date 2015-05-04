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
	protected boolean diffusion = false;

	/**
	 * Modifie les utilisateurs
	 * 
	 * @param users
	 * @throws RemoteException
	 */
	public Echange(Set<_Utilisateur> users) throws RemoteException {
		utilisateurs = users;
	}

	@Override
	public List<_Message> messages() throws RemoteException {
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
		if (this.diffusion == true) {
			this.diffuser(message);
		}
	}

	@Override
	public void addMessage(_Message message, boolean diffusion)
			throws RemoteException {
		message.setDate(new Date());
		messages.add(message);
		if (diffusion == true) {
			this.diffuser(message);
		}
	}

	@Override
	public void diffuser(_Message message) throws RemoteException {
		for (_Utilisateur utilisateur : utilisateurs) {
			utilisateur.afficher(message);
		}
	}

	public void diffuser(String texte) throws RemoteException {
		for (_Utilisateur utilisateur : utilisateurs) {
			utilisateur.afficher(texte);
		}
	}

	@Override
	public Set<_Utilisateur> utilisateurs() {
		return utilisateurs;
	}

	@Override
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		utilisateurs.add(utilisateur);
	}

	@Override
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		utilisateurs.remove(utilisateur);
	}

	@Override
	public boolean isDiffusion() throws RemoteException {
		return diffusion;
	}

	@Override
	public void setDiffusion(boolean diffusion) throws RemoteException {
		this.diffusion = diffusion;
	}

}
