import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

/*
 * Questa è la classe degli oggetti remoti a tutti gli effetti, infatti estende la classe UnicastRemoteObject e
 * implemnta l'interfaccia Subject. Quindi si definisce l'implemntazione dei metodi.
 * Implementazione dei tipi astratti.
 * 
 * Il prof forza la classe ad essere astratta, quindi non è istanziabile. Per istanziarla bisogna utilizzare una classe concreta,
 * che sarebbe ChatSubjectImpl
 */

abstract class AbstractSubject extends UnicastRemoteObject implements Subject{
	
	// Questa è una struttura (lista) che contiene un insieme di Observer
	private List<Observer> obs = new ArrayList<Observer>();

	protected AbstractSubject() throws RemoteException { }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Il metodo attach include l'Observer nella lista obs
	public void attach(Observer o) throws RemoteException {
		obs.add(o);
	}

	public void detach(Observer o) throws RemoteException {
		obs.remove(o);
	}

	// Il metodo notify informa gli Observer di una modifica di stato
	// Per tutti gli observer della lista invoca il metodo update, informando così gli altri Observer della presenza del nuovo messaggio (il msg viene scritto sullo stdout della macchina che ospita gli altri Observer)
	public void notify(Object msg) throws RemoteException {
		for(int i=0; i<obs.size(); i++)
			obs.get(i).update(msg);
	}

}