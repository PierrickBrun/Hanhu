package action;

import java.rmi.Remote;
import java.rmi.RemoteException;

import message._Message;

public interface _Envoi extends Remote {

	public void envoyer(_Message message) throws RemoteException;
}
