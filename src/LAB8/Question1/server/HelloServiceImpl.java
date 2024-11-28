package LAB8.Question1.server;

import LAB8.Question1.interfaces.HelloService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl implements HelloService {
    public HelloServiceImpl() {}

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name + "! Welcome to RMI!";
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the service
            HelloServiceImpl service = new HelloServiceImpl();

            // Create stub
            HelloService stub = (HelloService) UnicastRemoteObject.exportObject(service, 0);

            // Create registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the stub to the registry
            registry.rebind("HelloService", stub);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
