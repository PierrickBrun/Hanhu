package utilisateur;

public abstract class Utilisateur implements _Utilisateur {

	public abstract boolean checkPass(String pass);

	public abstract String pseudo();

}
