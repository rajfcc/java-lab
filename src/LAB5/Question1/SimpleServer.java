package LAB5.Question1;

import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 12345; // Port number to listen on
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Get input and output streams
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                // Read message from client
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Respond to client
                writer.println("Server received: " + message);

                // Close connection
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
