import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Task<T> extends Remote {
    //The Task method provided by the remote object
    public T quadratGeneric(T number) throws RemoteException;
}