package utilisateur;

public class Enregistr� extends Utilisateur{
	
	private String pseudo;
	private String pass;
	
	public Enregistr�(String pseudo, String pass){
		this.pseudo = pseudo;
		this.pass = pass;
	}
	
	@Override
	public boolean checkPass(String pass){
		return this.pass.equals(pass);
	}
	
	@Override
	public String pseudo(){
		return this.pseudo;
	}

}
