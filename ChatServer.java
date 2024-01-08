import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

/*
 * Questo codice avvia il processo Server.
 */

public class ChatServer {
	public static void main(String[] args) {
		try {
			// Viene creato un nuovo oggetto remoto Subject
			Subject s = new ChatSubjectImpl();
			// Viene avviato il registro
			LocateRegistry.createRegistry(1099);
			// L'oggetto remoto viene caricato nella tabella del registro con il nome chatsubject
			Naming.bind("rmi://127.0.0.1/chatsubject", s);
		} catch (AccessException e) {
			System.err.println("Bind operation not permitted");
		} catch (RemoteException e) {
			System.err.println("Registry could not be contacted");
		} catch (MalformedURLException e) {
			System.err.println("Wrong URL for dinding");
		} catch (AlreadyBoundException e) {
			System.err.println("Object already bound to the registry");
		}
	}
}
