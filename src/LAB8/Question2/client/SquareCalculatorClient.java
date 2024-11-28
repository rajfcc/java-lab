package LAB8.Question2.client;

import LAB8.Question2.interfaces.SquareCalculatorService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class SquareCalculatorClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object
            SquareCalculatorService calculatorService =
                    (SquareCalculatorService) registry.lookup("SquareCalculatorService");

            // Create scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Interactive client
            while (true) {
                System.out.print("Enter a number to calculate its square (or -1 to exit): ");
                int number = scanner.nextInt();

                // Exit condition
                if (number == -1) {
                    System.out.println("Exiting the application...");
                    break;
                }

                // Call remote method
                int result = calculatorService.calculateSquare(number);
                System.out.println("Square of " + number + " is: " + result);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}