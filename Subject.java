import java.rmi.*;

/*
 * Qui si definisce l'interfaccia degli oggetti remoti e si definisce il prototipo dei metodi che questi oggetti espongono.
 * I metodi sono attach, detach e notify, quindi questa è l'interfaccia del Subject.
 */

public interface Subject extends Remote{
	public void attach(Observer o) throws RemoteException;
	public void detach(Observer o) throws RemoteException;
	public void notify(Object msg) throws RemoteException;
	//public void notify() throws RemoteException; notify dovrebbe essere così ma noi consideriamo una variante del pattern Observer (dovrebbe solo notificara il cambiamneto di stato ma non il cambiamento)
	//public void notify() throws RemoteException;
}
