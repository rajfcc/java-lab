package LAB.lab4Question10CustomException;

public class Main {

    public static void main(String[] args) {
        try {
            // Test the validateAge method with an invalid age
            validateAge(-5); // This will throw an InvalidAgeException
        } catch (InvalidAgeException e) {
            // Catch and handle the custom exception
            System.out.println("Caught an exception: " + e.getMessage());
        }

    }

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            // Throw the custom exception with a message
            throw new InvalidAgeException("Age must be between 0 and 150. Provided age: " + age);
        }
        System.out.println("Valid age: " + age);
    }
}

