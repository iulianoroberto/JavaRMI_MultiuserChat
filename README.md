# Java_RMI_multiuser_chat
Implementation of a multiuser chat as a distributed application (Java RMI and pattern Observer).

Implement a multiuser chat as a distributed application: the messages sent by a client must be propagated to all other clients connected to the server.
In the context of object-oriented programming, we can exploit the Observer behavioural pattern to define a micro-architecture to ease the development.

To implement the multi-user chat application, the server must host a remote object that works as Subject of the Observer pattern. Clients should host remote objects working as Observer(s) of the same pattern. Use Java RMI to implement Subject and Observer.

## Italiano
Implementazione di una chat multi-utente come applicazione distribuita: il messaggio inviato da un cliente viene propagato a tutti gli altri client connessi al server. Al fine di implementare tale applicazione è stato sfruttato il design pattern observer (pattern comportamentale).

Il design pattern Observer prevede essenzialmente la presenza di due entità, che sono Subject e Observer. Il Subject è l'entità osservata di cui sono di interesse le modifiche di stato e l'Observer è l'entità che opera l'sservazione. Nel momento in cui un Observer decide di osservare un determinato Subject invoca il relativo metodo *attach()*. Quando un Subject è soggetto ad una modifica di stato vene invocato il metodo *notify()* (il metodo può essere invocato dal Subject stesso o da un'entità esterna). L'invocazione di *notify()* sul Subject prevede la corrispondente invocazione del metodo *update()* sull'Observer. Nell'implementazione "earlier" el pattern con *update()* viene comunicato all'Observer la modifca di stato, mentre nel'implemntazione "lazy" del pattern viene solo notificata la modifca di stato all'Observer, che poi si occuperà di recuperare la modifica (per questo implemntazione pigra-"lazy").

Al fine di realizzare l'applicazione, la componente client ospita un oggetto remoto di tipo Subject, che viene registrato dal Server sul Binder. Ogni componente Client ospita un oggetto remoto di tipo Observer, che viene passato al Subject tramite il metodo remoto *attach()*. Quando si verifica una modifica di stato sul Subject (messaggio inviato da un client) quella odifica viene comunicata a tutti gli Observer (il messaggio viene propagato).
