package utilisateur;

public class Inscrit extends Utilisateur{
	
	private String pseudo;
	private String pass;
	
	public Inscrit(String pseudo, String pass){
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
