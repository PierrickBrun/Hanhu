package stockage;

import java.rmi.RemoteException;

import utilisateur._Utilisateur;

public interface _StockageZone extends _Stockage {

	@Override
	void setAcces(boolean autorisation, _Utilisateur user)throws RemoteException;

}
