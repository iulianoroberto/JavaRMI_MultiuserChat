# Java_RMI_multiuser_chat
Implementation of a multiuser chat as a distributed application (Java RMI and pattern Observer).

Implement a multiuser chat as a distributed application: the messages sent by a client must be propagated to all other clients connected to the server.
In the context of object-oriented programming, we can exploit the Observer behavioural pattern to define a micro-architecture to ease the development.

To implement the multi-user chat application, the server must host a remote object that works as Subject of the Observer pattern. Clients should host remote objects working as Observer(s) of the same pattern. Use Java RMI to implement Subject and Observer.

![alt text](https://github.com/iulianoroberto/Java_RMI_multiuser_chat/blob/main/Images/DPObserver.PNG)

## Spiegazione in italiano
Implementazione di una chat multi-utente come applicazione distribuita: il messaggio inviato da un client viene propagato a tutti gli altri client connessi al server. Al fine di implementare tale applicazione è stato sfruttato il design pattern Observer (pattern comportamentale).

Il design pattern Observer prevede essenzialmente la presenza di due entità, che sono Subject e Observer. Il Subject è l'entità osservata di cui sono di interesse le modifiche di stato e l'Observer è l'entità che opera l'osservazione. Nel momento in cui un Observer decide di osservare un determinato Subject invoca il relativo metodo *attach()*. Quando un Subject è soggetto ad una modifica di stato vene invocato il metodo *notify()* (il metodo può essere invocato dal Subject stesso o da un'entità esterna). L'invocazione di *notify()* sul Subject prevede la corrispondente invocazione del metodo *update()* sull'Observer. Nell'implementazione "earlier" del pattern con *update()* viene comunicato all'Observer la modifca di stato, mentre nell'implemntazione "lazy" del pattern viene solo notificata la modifca di stato all'Observer, che poi si occuperà di recuperare la modifica (per questo implemntazione pigra-"lazy").

Al fine di realizzare l'applicazione, la componente client ospita un oggetto remoto di tipo Subject, che viene registrato dal server sul binder. Ogni componente client ospita un oggetto remoto di tipo Observer, che viene passato al Subject tramite il metodo remoto *attach()*. Quando si verifica una modifica di stato sul Subject (messaggio inviato da un client) quella odifica viene comunicata a tutti gli Observer (il messaggio viene propagato).

Il codice di Stub (lato client) e Skeleton (lato server) è stato generato tramite il tool rmic (nota che il tool rmic è deprecato e la generazione degli stub avviene sfruttando la reflection).

### Come eseguirlo?
- Scarica i file con estensione .java e posizionali in una cartella.
- Compila i file, a tal fine puoi sfruttare il compilatore javac ***javac \*.java*** (da console).
- Se vuoi puoi rigenerare Stub e Skeleton sfruttando il tool rmic ***rmic -keep -v1.1 AbstractSubject*** (da console).
- Avvia il server ***java ChatServer*** (nota che nel server è previsto l'avvio del binder).
- Avvia il client ***java ChatClient***.
