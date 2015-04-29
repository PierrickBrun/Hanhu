package serveur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import client.Client;
import client._Client;
import action.echange.*;
import message.*;
import utilisateur.*;

public class Serveur extends UnicastRemoteObject implements _Serveur {

	private static final long serialVersionUID = -6046874410587068537L;

	public Set<_Discussion> discussions = new HashSet<_Discussion>();
	public Set<_Diffusion> diffusions = new HashSet<_Diffusion>();
	private Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();

	/**
	 * Constructeur serveur
	 * 
	 * @throws RemoteException
	 */
	public Serveur() throws RemoteException {
		super();
	}

	/**
	 * Ajoute un utilisateur à la liste des utilisateurs
	 * 
	 * @param utilisateur
	 */
	private void addUser(Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	@Override
	public _Utilisateur getUtilisateur(String name) throws RemoteException {
		for (_Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.pseudo().equals(name)) {
				return utilisateur;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
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

	/**
	 * Diffusion et affichage du message à tout les utilisateurs de la liste
	 * 
	 * @param message
	 * @param destinataires
	 * @throws RemoteException
	 */
	public void diffuser(_Message message, Set<Utilisateur> destinataires)
			throws RemoteException {
		for (_Utilisateur user : destinataires) {
			user.afficher(message.toString());
		}
	}

	@Override
	public Utilisateur connexion(_Client client) throws RemoteException {
		Anonyme anonyme = new Anonyme(utilisateurs.size());
		addUser(anonyme);
		anonyme.setClient(client);
		return anonyme;
	}

	@Override
	public _Utilisateur connexion(String pseudo, String pass, _Client client)
			throws RemoteException {
		for (_Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.pseudo().equals(pseudo)) {
				if (utilisateur.checkPass(pass)) {
					utilisateur.setClient(client);
					return utilisateur;
				}
			}
		}
		return null;
	}

	@Override
	public _Utilisateur nouvUtilisateur(String pseudo, String pass)
			throws RemoteException {
		for (_Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.pseudo().equals(pseudo)) {
				return null;
			}
		}
		Inscrit inscrit = new Inscrit(pseudo, pass);
		addUser(inscrit);
		return inscrit;
	}

	@Override
	public _Client nouvClient() throws RemoteException {
		_Client client = new Client(this);
		return client;
	}

	@Override
	public _Diffusion diffusion(Set<_Utilisateur> utilisateurs)
			throws RemoteException {
		for (_Diffusion diffusion : diffusions) {
			for (_Utilisateur userDiscu : diffusion.utilisateurs()) {
				boolean contains = false;
				for (_Utilisateur user : utilisateurs) {
					if (user.pseudo().equals(userDiscu.pseudo())) {
						contains = true;
					}
				}
				if (contains == false) {
					_Diffusion ajout = new Diffusion(utilisateurs);
					this.diffusions.add(ajout);
					return ajout;
				}
			}
			return diffusion;
		}
		_Diffusion ajout = new Diffusion(utilisateurs);
		this.diffusions.add(ajout);
		return ajout;
	}

	@Override
	public _Asynchrone nouvAsynchrone() throws RemoteException {
		return new Asynchrone(this);
	}

	@Override
	public _Discussion discussion(Set<_Utilisateur> utilisateurs)
			throws RemoteException {
		for (_Discussion discussion : discussions) {
			for (_Utilisateur userDiscu : discussion.utilisateurs()) {
				boolean contains = false;
				for (_Utilisateur user : utilisateurs) {
					if (user.pseudo().equals(userDiscu.pseudo())) {
						contains = true;
					}
				}
				if (contains == false) {
					_Discussion ajout = new Discussion(utilisateurs);
					this.discussions.add(ajout);
					return ajout;
				}
			}
			return discussion;
		}
		_Discussion ajout = new Discussion(utilisateurs);
		this.discussions.add(ajout);
		return ajout;
	}

	@Override
	public void uploadFile(String fichier, String adresse)
			throws RemoteException {
		FileChannel fichierEntree = null;
		FileChannel FichierSortie = null;
		try {

			fichierEntree = new FileInputStream(
					"\\home\\z\\zucarom\\Documents\\" + fichier).getChannel();
			FichierSortie = new FileOutputStream(adresse + fichier)
					.getChannel();

			fichierEntree.transferTo(0, fichierEntree.size(), FichierSortie);
			System.out.println("J'ai copié");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fichierEntree != null) {
				try {
					fichierEntree.close();
				} catch (IOException e) {
				}
			}
			if (FichierSortie != null) {
				try {
					FichierSortie.close();
				} catch (IOException e) {
				}
			}
		}
		System.out.println("C'est finit !");

	}

	@Override
	public void downloadFile(String nom, String adresse) throws RemoteException {
		FileChannel fichierEntree = null;
		FileChannel FichierSortie = null;
		try {

			fichierEntree = new FileInputStream(adresse + nom).getChannel();
			FichierSortie = new FileOutputStream(
					"\\home\\z\\zucarom\\Documents\\" + nom).getChannel();

			// Copie depuis le in vers le out
			fichierEntree.transferTo(0, fichierEntree.size(), FichierSortie);
			System.out.println("J'ai copié");
		} catch (Exception e) {
			e.printStackTrace(); // n'importe quelle exception
		} finally { // finalement on ferme
			if (fichierEntree != null) {
				try {
					fichierEntree.close();
				} catch (IOException e) {
				}
			}
			if (FichierSortie != null) {
				try {
					FichierSortie.close();
				} catch (IOException e) {
				}
			}
		}
		System.out.println("C'est finit !");

	}

	@Override
	public _Message nouvMessage(Object texte, _Utilisateur expediteur)
			throws RemoteException {
		return new Message(expediteur, texte);
	}

	@Override
	public Set<_Utilisateur> utilisateurs() {
		return utilisateurs;
	}

}