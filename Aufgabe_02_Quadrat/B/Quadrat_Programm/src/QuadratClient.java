import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class QuadratClient {
    public static void main(String[] args) {
        try {
            //Get the arguments
            if (args.length < 3) {
                System.out.println("Usage: java HelloClient <server host> <long number> <any type>");
                return;
            }
            String host = args[0];
            long number = Long.parseLong(args[1]);
            Object o = args[2];
            //Get remote object references
            Registry registry = LocateRegistry.getRegistry(host);
            Quadrat q = (Quadrat) registry.lookup("Quadrat1");
            Task t = (Task) registry.lookup("Generic1");
            //Call remote method
            System.out.println("Das Quadrat von " + number + " = " + q.quadrat(number));
            System.out.println("Genernic Methode liefert folgendes: " + t.quadratGeneric(o));
        } catch (Exception e) {
            System.err.println("Error on client: " + e);
        }
    }
}
