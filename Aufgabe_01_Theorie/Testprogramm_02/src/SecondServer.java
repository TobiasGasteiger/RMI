import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class SecondServer {
    public static void main(String[] args) {
        try {
            // Create a Hello remote object
            HelloImpl h = new HelloImpl("Hello world !");
            Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
            SecondImpl s = new SecondImpl();
            Second s_stub = (Second) UnicastRemoteObject.exportObject(s, 1);
            //Create the registry
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            // Register the remote object in RMI registry with a given identifier
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello1", h_stub);
            registry.bind("second", s_stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Error on server :" + e);
            e.printStackTrace();
        }
    }
}