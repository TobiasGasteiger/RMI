import java.rmi.registry.*;

public class SecondClient {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java HelloClient <server host>");
                return;
            }
            String host = args[0];
            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Hello h = (Hello) registry.lookup("Hello1");
            Second s = (Second) registry.lookup("second");
            //Person creation
            Person p = new Person("Vania", "Marangozova");
            // Remote method invocation
            String res = h.sayHello();
            System.out.println(res);
            String res2 = s.sayHi(10, h, p);
            System.out.println(res2);
        } catch (Exception e) {
            System.err.println("Error on client: " + e);
        }
    }
}