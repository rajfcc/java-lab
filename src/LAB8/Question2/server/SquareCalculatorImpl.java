package LAB8.Question2.server;

import LAB8.Question2.interfaces.SquareCalculatorService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SquareCalculatorImpl implements SquareCalculatorService {
    public SquareCalculatorImpl() {}

    @Override
    public int calculateSquare(int number) throws RemoteException {
        return number * number;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the service
            SquareCalculatorImpl calculatorService = new SquareCalculatorImpl();

            // Create stub
            SquareCalculatorService stub =
                    (SquareCalculatorService) UnicastRemoteObject.exportObject(calculatorService, 0);

            // Create registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the stub to the registry
            registry.rebind("SquareCalculatorService", stub);

            System.out.println("Square Calculator RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}