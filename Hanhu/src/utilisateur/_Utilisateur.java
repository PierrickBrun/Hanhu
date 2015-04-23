package utilisateur;

import java.io.Serializable;

public interface _Utilisateur extends Serializable {

	public abstract boolean checkPass(String pass);

	public abstract String pseudo();

}
