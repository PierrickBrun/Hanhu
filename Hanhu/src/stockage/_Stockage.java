package stockage;

import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _Stockage {

	void setAcces(boolean autorisation, _Utilisateur user)
			throws RemoteException;

}
