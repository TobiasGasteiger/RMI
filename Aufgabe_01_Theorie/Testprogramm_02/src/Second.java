import java.rmi.*;
public interface Second extends Remote {
// Method provided by the remote object
    public String sayHi( int c, Hello o, Person p)
            throws RemoteException;
} 