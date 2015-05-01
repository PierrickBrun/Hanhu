package utilisateur;

import java.rmi.RemoteException;

public class Anonyme extends Utilisateur {

	private static final long serialVersionUID = -8722552988346551253L;
	protected int id = 0;

	/**
	 * Constructeur Anonyme
	 * 
	 * @param id
	 * @throws RemoteException
	 */
	public Anonyme(int id) throws RemoteException {
		this.id = id;
	}

	@Override
	public boolean checkPass(String pass) {
		return false;
	}

	@Override
	public String pseudo() {
		return "guest" + id;
	}

	@Override
	public boolean connecte() throws RemoteException {
		return true;
	}

	@Override
	public void setConnecte(boolean connecte) throws RemoteException {
		this.connecte = connecte;
	}

}
