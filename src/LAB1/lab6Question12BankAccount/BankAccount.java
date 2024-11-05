package LAB1.lab6Question12BankAccount;

public class BankAccount {
    private float balance;

    public BankAccount(float balance){
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void withdraw(float amount){
        if (balance > amount){
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
        }
        else{
            System.out.println("Insufficient balance. "+Thread.currentThread().getName() + " can't withdraw " + amount);
        }
        System.out.println("Balance: "+ balance);
    }
}
