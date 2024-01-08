import java.rmi.*;

/*
 * Questa è l'interfaccia Observer che definisce i prototipi dei metodi che esporranno gli oggeti remoti Observer.
 * Gli oggetti Observer sono istanizati nei processi che operano da Client.
 */

interface Observer extends Remote {

	// Il metodo update serve ad inviare all'Observer il nuovo stato (ossia il messaggio) e viene invocato dal Subject
	void update(Object msg) throws RemoteException;
	//void update() throws RemoteException; dovrebbe essere questo ma noi consideriamo una variante del pattern Observer
}
