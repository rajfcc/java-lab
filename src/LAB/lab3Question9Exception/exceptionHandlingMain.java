package LAB.lab3Question9Exception;

public class exceptionHandlingMain {
    public static void divideByZero() throws ArithmeticException {
        throw new ArithmeticException("Trying to divide by 0");
    }
    public static void main(String[] args) {
        try {
            int[] myNumbers = {1, 2, 3};
//            System.out.println("Enter the index you want to access: ");
//            Scanner sc = new Scanner(System.in);
//            int index = sc.nextInt();
            System.out.println(myNumbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Exception => "+ e.getMessage());
            throw new ArrayIndexOutOfBoundsException();

        }
        finally {
            assert System.out !=null;
            System.out.println("Finally is executed");
        }
    }
}
