package LAB5.Question2;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        // Message to send to server
        String message = "Hello from client";
        sendData = message.getBytes();

        // Send packet to server
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        // Receive response from server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Received from server: " + serverResponse);
        String exitMessage = "exit";
        sendData = exitMessage.getBytes();

        // Send packet to server
        DatagramPacket sendexitPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendexitPacket);

        clientSocket.close();
    }
}
