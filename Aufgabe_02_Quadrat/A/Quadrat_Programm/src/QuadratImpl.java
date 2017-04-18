import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Tobias on 18.04.2017.
 */
public class QuadratImpl implements Quadrat{
    @Override
    public long quadrat(long number) throws RemoteException {
        return number * number;
    }

    public static void main(String[] args) {
        try {
            /*
            Would be to complicated to change policy files
            // Create and install a security manager
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }*/
            //Create the quadratRemote Remote Object
            QuadratImpl quadratRemote = new QuadratImpl();
            Quadrat q_stub = (Quadrat) UnicastRemoteObject.exportObject(quadratRemote, 0);
            //Create the registry
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            // Register the remote object in RMI registry with a given identifier
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Quadrat1", q_stub);
            System.out.println("Server ready");
        } catch (RemoteException e) {
            System.err.println("RemoteException on server :" + e);
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.err.println("AlreadyBoundException on server :" + e);
            e.printStackTrace();
        }
    }
}
