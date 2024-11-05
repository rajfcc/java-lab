package LAB1.lab6Question12BankAccount;

public class Main {
    public static void main(String[] args){
        BankAccount account = new BankAccount(50000);
        ThreadedWithdraw obj1 = new ThreadedWithdraw(10000,account);
        ThreadedWithdraw obj2 = new ThreadedWithdraw(20000,account);
        ThreadedWithdraw obj3 = new ThreadedWithdraw(50000,account);

        obj1.start();
        obj2.start();
        obj3.start();

        try {
            obj1.join();
            obj2.join();
            obj3.join();
        }
        catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
