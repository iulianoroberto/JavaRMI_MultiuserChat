import java.rmi.*;
import java.rmi.server.*;

/*
 * Questa è la classe degli oggetti remoti Observer che estende la classe UnicastRemoteObject e implementa l'interfaccia Observer,
 * quindi ne definisce il corpo dei metodi.
 */

class ChatObserverImpl extends UnicastRemoteObject implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Il costruttore
	protected ChatObserverImpl() throws RemoteException { }

	// Il metodo update, ricevuto il messaggio da chi invoca il metodo (il Subject), stampa sullo stdout della macchina che ospita il processo Observer (client) il messaggio ricevuto
	public void update(Object msg) throws RemoteException {
		System.out.println("Received: " + msg);
		
	}
	
	// Eventuale variante
	// Questa sarebbe l'update senza parametro e quindi c'è l'invocazione di getState su Subject per recuperare lo stato
	// Sarebbe più complesso perché il Subject dovrebbe memorizzare tutte le stringhe, in questo caso ha solo uno stato apparente
	/* 
	public void update() throws RemoteException {
		System.out.println(subj.getState());
	}*/

}
