package serveur;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.Set;

import utilisateur.*;


public class Serveur implements Remote, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5412991223900807232L;
	private Set<Stockage> stockages;
	private Set<Utilisateur> utilisateurs;
	
	/**
	 * connecte un utilisateur anonymement, créé à la volée
	 * @return utilisateur créé
	 */
	public Utilisateur connexion() {
		Anonyme anonyme = new Anonyme();
		return anonyme;
	}
	
	
	/**
	 * connecte un utilisateur enregistré
	 * @param pseudo
	 * @param pass
	 * @return
	 */
	public Utilisateur connexion(String pseudo, String pass) {
		for(Utilisateur utilisateur : utilisateurs){
			if(utilisateur.pseudo().equals(pseudo)){
				if(utilisateur.checkPass(pass)){
					return utilisateur;
				}
			}
		}
		return null;
	}

}
