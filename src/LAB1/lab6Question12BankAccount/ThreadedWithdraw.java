package LAB1.lab6Question12BankAccount;

public class ThreadedWithdraw extends Thread{
    private final float amount;
    private final BankAccount account;

    public ThreadedWithdraw(float amount,BankAccount account){
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void run() {
        synchronized (account){
            account.withdraw(amount);
        }
    }
}
