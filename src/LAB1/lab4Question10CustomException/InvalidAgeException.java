package LAB1.lab4Question10CustomException;

// Custom Exception class
public class InvalidAgeException extends Exception {
    // Constructor that accepts a message
    public InvalidAgeException(String message) {
        super(message);
    }
}

