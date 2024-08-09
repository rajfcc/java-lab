package LAB.lab1Question1Interface;

class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car Engine Started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car Engine Stopped");
    }
}
