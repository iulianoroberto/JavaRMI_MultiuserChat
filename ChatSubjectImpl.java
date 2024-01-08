import java.rmi.*;

/*
 * Questa è la classe concreta del Subject che prevede solo il costruttore perché tutti i metodi
 * sono già stai definiti nella classe astratta.
 * Avremmo anche potuto evitare la classe astratta ma così quella può essere riutilizzata per altre applicazioni.
 */

public class ChatSubjectImpl extends AbstractSubject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Costruttore
	public ChatSubjectImpl() throws RemoteException { }
	
	/*
	 * Se avvessimo previsto i metodi getState e setState qui sarebbe stato presente lo stato specifico
	 * dell'oggetto. Non ci sono perché si sta considerando una variante del design patter comportamentale Observer.
	 */

	// public Object getState() { return null; }
	// public void setState(Object o);
	
}
