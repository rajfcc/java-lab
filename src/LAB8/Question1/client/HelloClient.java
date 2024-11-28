package LAB8.Question1.client;

import LAB8.Question1.interfaces.HelloService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object
            HelloService service = (HelloService) registry.lookup("HelloService");

            // Call remote method
            String response = service.sayHello("RMI User");
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}