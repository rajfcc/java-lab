package LAB5.Question2;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);  // Create socket on port 9876
        byte[] receiveData = new byte[1024];

        System.out.println("Server is running...");

        while (true) {
            // Receive packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMessage);
            // Prepare response data
            String responseMessage = "Hello from server";
            byte[] sendData = responseMessage.getBytes();
            // Send response to client
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
            // Break if a specific message (like "exit") is received
            if (clientMessage.equalsIgnoreCase("exit")) {
                System.out.println("Server is exiting...");
                break;
            }
        }

        serverSocket.close();
    }
}


