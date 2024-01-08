import java.rmi.*;
import java.net.*;
import java.util.*;

/*
 * Questo codice da vita al processo client (più che di un client si trova di un peer)
 */

public class ChatClient {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			// Si recupera tramite la lookup il reference globale dell'oggetto remoto chatsubject
			Subject s = (Subject)Naming.lookup("rmi://127.0.0.1/chatsubject");
			// Si crea un nuovo oggetto remoto observer (locale al client ma remoto al server)
			Observer o = new ChatObserverImpl(); // Si impianta un oggetto nel client e ad esso sarà associato un thread che sarà asincrono rispetto al thread del main
			// Si invoca il metodo attach sull'oggetto renmoto Subject per "attaccare" l'Observer (è come se il Subject funzionasse da registro)
			s.attach(o);
			sc = new Scanner (System.in);
			String msg = null;
			do {
				System.out.println("Scrivi> ");
				System.out.flush();
				msg = sc.nextLine();
				/*
				 * Se l'Observer (client) scrive un messaggio allora viene invocato il metodo notify dell'oggetto remoto Subject
				 */
				s.notify(msg);
			} while (!msg.endsWith(".")); // La condizione di uscita dal ciclo è la digitazione del carattere punto

			/*
			 * Eccezzioni necessarie per la creazione di un oggetto remoto oltre ad effettuare l'operazione di lookup.
			 */

		} catch(RemoteException e) {
			System.err.println("Remote invocation error" + e);
		} catch(MalformedURLException e) {
			System.err.println("Wrong URL for binding");
		} catch(NotBoundException e) {
			System.err.println("Object not bound");
		} finally {
			if (sc != null) sc.close();
		}
	}
}
