package LAB8.Question2.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareCalculatorService extends Remote {
    int calculateSquare(int number) throws RemoteException;
}