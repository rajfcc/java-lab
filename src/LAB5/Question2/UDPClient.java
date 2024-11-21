package LAB5.Question2;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int serverPort = 12345; // Server port number

        try (DatagramSocket socket = new DatagramSocket()) {
            // Send message to server
            String message = "Hello Server!";
            byte[] buffer = message.getBytes();
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverInetAddress, serverPort);
            socket.send(packet);
            System.out.println("Message sent to the server.");

            // Receive response from server
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server responded: " + response);

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
