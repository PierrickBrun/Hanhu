package utilisateur;

import java.rmi.RemoteException;

public class Anonyme extends Utilisateur {

	private static final long serialVersionUID = -8722552988346551253L;
	private int id = 0;

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

}
