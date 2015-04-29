package action;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Reception extends Remote {

	public Object recevoir() throws RemoteException;

}
