package utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Utilisateur extends Remote {

	public boolean checkPass(String pass) throws RemoteException;

	public String pseudo() throws RemoteException;

	public void afficher(String message) throws RemoteException;

}
