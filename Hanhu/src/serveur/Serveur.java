package serveur;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import action.echange.*;
import message.*;
import utilisateur.*;

public class Serveur extends UnicastRemoteObject implements _Serveur {

	private static final long serialVersionUID = -6046874410587068537L;

	protected Serveur() throws RemoteException {
		super();
	}

	public LinkedList<_Message> diffusions = new LinkedList<_Message>();
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>();

	private void addUser(Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	public void addDiffusion(_Message message) throws RemoteException {
		message.setDate(new Date());
		diffusions.add(message);
	}

	@SuppressWarnings("unchecked")
	public Collection<_Message> getList(String name, _Utilisateur utilisateur) {
		Class<?> c = this.getClass();
		Field f;
		Collection<_Message> coll;
		try {
			f = c.getDeclaredField(name);
			f.setAccessible(true);
			coll = (Collection<_Message>) f.get(this);
		} catch (Exception e) {
			return null;
		}
		return coll;
	}

	public void diffuser(Object objet) {
	}

	/**
	 * connecte un utilisateur anonymement, créé à la volée
	 * 
	 * @return utilisateur créé
	 * @throws RemoteException
	 */
	public Utilisateur connexion() throws RemoteException {
		Anonyme anonyme = new Anonyme(utilisateurs.size());
		addUser(anonyme);
		return anonyme;
	}

	/**
	 * connecte un utilisateur enregistré
	 * 
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public Utilisateur connexion(String pseudo, String pass) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.pseudo().equals(pseudo)) {
				if (utilisateur.checkPass(pass)) {
					return utilisateur;
				}
			}
		}
		return null;
	}

	@Override
	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException {
		Inscrit inscrit = new Inscrit(pseudo, pass);
		addUser(inscrit);
		return inscrit;
	}

	@Override
	public _Diffusion nouvDiffusion() throws RemoteException {
		return new Diffusion(this);
	}

	@Override
	public _Asynchrone nouvAsynchrone() throws RemoteException {
		return new Asynchrone(this);
	}

}