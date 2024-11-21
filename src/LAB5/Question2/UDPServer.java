package LAB5.Question2;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        int port = 12345; // Port number to listen on

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Server is listening on port " + port);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive data from client
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + message);

            // Respond to client
            String response = "Server received: " + message;
            byte[] responseData = response.getBytes();
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();

            DatagramPacket responsePacket = new DatagramPacket(
                    responseData, responseData.length, clientAddress, clientPort);
            socket.send(responsePacket);

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
