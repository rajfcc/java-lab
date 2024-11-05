package LAB1.lab5Question12Multithreading;

// Extending Thread class

class ThreadTask extends Thread {
    private String taskName;

    public ThreadTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate task taking time
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
        System.out.println(taskName + " has finished.");
    }
}