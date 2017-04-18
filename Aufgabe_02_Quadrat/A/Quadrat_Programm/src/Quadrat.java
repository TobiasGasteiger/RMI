import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quadrat extends Remote{
    //The quadrat method provided by the remote object
    public long quadrat(long number) throws RemoteException;
}
