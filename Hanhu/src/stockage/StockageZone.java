package stockage;

import java.io.*;
import java.nio.channels.FileChannel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import utilisateur.Utilisateur;
import utilisateur._Utilisateur;

public class StockageZone extends UnicastRemoteObject implements _StockageZone {

	private static final long serialVersionUID = -9207428016786805220L;
	protected String nom;
	protected String adresse;
	protected Set<File> ListeFichier = new HashSet<File>();
	protected LinkedList<_Utilisateur> ListUsers = new LinkedList<_Utilisateur>();

	/**
	 * Constructeur de la zone
	 * 
	 * @param nom
	 * @param user
	 * @throws RemoteException
	 */
	public StockageZone(String nom, Utilisateur user, String adresse)
			throws RemoteException {
		super();
		this.nom = nom;
		this.adresse = adresse;
		File dir = new File(adresse + this.nom);
		dir.mkdirs();
		ListUsers.add(user);
	}

	@Override
	public void setAcces(boolean autorisation, _Utilisateur user)
			throws RemoteException {
		if (autorisation) {
			ListUsers.add(user);
		} else
			ListUsers.remove(user);
	}

	@Override
	public String adresse() throws RemoteException {
		return adresse;
	}

	@Override
	public String nom() throws RemoteException {
		return nom;
	}

	@Override
	public void addFile(File fichier) throws RemoteException {
		ListeFichier.add(fichier);
		FileChannel fichierEntree = null;
		FileChannel FichierSortie = null;
		try {

			fichierEntree = new FileInputStream(fichier).getChannel();
			FichierSortie = new FileOutputStream(adresse + "/"
					+ fichier.getName()).getChannel();
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
	public File fichier(String nom) throws RemoteException {
		for (File fichier : ListeFichier) {
			if (fichier.getName().contentEquals(nom)) {
				return fichier;
			}
		}
		return null;
	}

}
