package action.echange;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import message._Echange;
import message._Message;

public class Synchrone implements _Synchrone {

	private _Echange echange;

	public Synchrone(_Echange echange) throws RemoteException {
		this.echange = echange;
	}

	@Override
	public List<_Message> recevoir() throws RemoteException {
		return echange.messages();

	}

	@Override
	public List<_Message> recevoir(Date date) throws RemoteException {
		return echange.messages(date);
	}

}
