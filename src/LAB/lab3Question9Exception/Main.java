package LAB.lab3Question9Exception;
public class Main {

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0; // This will cause a division by zero exception

        try {
            // Attempt to divide by zero
            int result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Catch the ArithmeticException and print an error message
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // This block will always execute, regardless of whether an exception was thrown
            System.out.println("Execution of the try-catch block is complete.");
        }

        // Code execution continues here
        System.out.println("Program continues after the try-catch-finally block.");
    }

    // Method to divide two numbers
    public static int divide(int num1, int num2) {
        return num1 / num2;
    }
}

