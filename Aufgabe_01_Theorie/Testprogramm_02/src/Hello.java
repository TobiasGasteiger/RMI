import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    // A method provided by the remote object
    public String sayHello() throws RemoteException;
} 