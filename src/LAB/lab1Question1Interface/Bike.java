package LAB.lab1Question1Interface;

class Bike implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bike Engine Started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Bike Engine Stopped");
    }
}
