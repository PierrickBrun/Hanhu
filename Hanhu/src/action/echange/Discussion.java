package action.echange;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import message.*;
import utilisateur.*;

public class Discussion extends Diffusion implements _Discussion, _Synchrone {

	public Discussion(_Echange echange) throws RemoteException {
		super(echange);
	}

	private static final long serialVersionUID = 3997108109331074580L;
	protected _Echange echange;

	@Override
	public List<_Message> recevoir() throws RemoteException {
		return echange.messages();
	}

	@Override
	public List<_Message> recevoir(Date date) throws RemoteException {
		return echange.messages(date);
	}

	@Override
	public void addUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		echange.addUtilisateur(utilisateur);
	}

	@Override
	public void delUtilisateur(_Utilisateur utilisateur) throws RemoteException {
		echange.delUtilisateur(utilisateur);
	}
}
