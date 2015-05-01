package serveur;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

import client.Client;
import client._Client;
import action.echange.*;
import message.*;
import stockage.StockageZone;
import stockage._StockageZone;
import utilisateur.*;

public class Serveur extends UnicastRemoteObject implements _Serveur {

	private static final long serialVersionUID = -6046874410587068537L;

	protected Set<_Utilisateur> utilisateurs = new HashSet<_Utilisateur>();
	protected Set<_Echange> echanges = new HashSet<_Echange>();
	protected _StockageZone zone = new StockageZone("zoneServeur", null, "/");

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
	public _Echange echange(Set<_Utilisateur> utilisateurs)
			throws RemoteException {
		for (_Echange echange : echanges) {
			if (echange.utilisateurs().equals(utilisateurs)) {
				return echange;
			}
		}
		_Echange nouvEchange = new Echange(utilisateurs);
		echanges.add(nouvEchange);
		return nouvEchange;
	}

	@Override
	public void uploadFile(File fichier, _StockageZone zone)
			throws RemoteException {
		zone.addFile(fichier);
	}

	@Override
	public File downloadFile(String fichier, _StockageZone zone)
			throws RemoteException {
		File file = zone.fichier(fichier);
		System.out.println("Download finit");
		return file;
	}

	@Override
	public _StockageZone getZone() throws RemoteException {
		return this.zone;
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

	@Override
	public _Asynchrone nouvAsynchrone(_Echange echange) throws RemoteException {
		return new Asynchrone(echange);
	}

	@Override
	public _Synchrone nouvSynchrone(_Echange echange) throws RemoteException {
		return new Synchrone(echange);
	}

	@Override
	public _Discussion nouvDiscussion(_Echange echange) throws RemoteException {
		return new Discussion(echange);
	}

	@Override
	public _Diffusion nouvDiffusion(_Echange echange) throws RemoteException {
		return new Diffusion(echange);
	}

}