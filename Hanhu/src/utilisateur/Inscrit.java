package utilisateur;

import java.rmi.RemoteException;

public class Inscrit extends Utilisateur {

	private static final long serialVersionUID = 4661858698250560949L;
	protected String pseudo;
	protected String pass;
	

	/**
	 * Constructeur Inscrit
	 * 
	 * @param pseudo
	 * @param pass
	 * @throws RemoteException
	 */
	public Inscrit(String pseudo, String pass) throws RemoteException {
		this.pseudo = pseudo;
		this.pass = pass;
	}

	@Override
	public boolean checkPass(String pass) {
		return this.pass.equals(pass);
	}

	@Override
	public String pseudo() {
		return this.pseudo;
	}

	@Override
	public boolean connecte() throws RemoteException {
		return this.connecte;
	}

	@Override
	public void setConnecte(boolean connecte) throws RemoteException {
		this.connecte = connecte;
	}

}
