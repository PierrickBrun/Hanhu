package utilisateur;

public class Anonyme extends Utilisateur {
	private int id = 0;

	public Anonyme() {
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
