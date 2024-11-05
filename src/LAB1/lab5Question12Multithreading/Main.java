package LAB1.lab5Question12Multithreading;


public class Main {
    public static void main(String[] args) {
        // Using Runnable interface
        Runnable runnableTask1 = new RunnableTask("Runnable Task 1");
        Runnable runnableTask2 = new RunnableTask("Runnable Task 2");

        Thread thread1 = new Thread(runnableTask1);
        Thread thread2 = new Thread(runnableTask2);

        thread1.start();
        thread2.start();

        // Using Thread class
        ThreadTask threadTask1 = new ThreadTask("Thread Task 1");
        ThreadTask threadTask2 = new ThreadTask("Thread Task 2");

        threadTask1.start();
        threadTask2.start();
    }
}
