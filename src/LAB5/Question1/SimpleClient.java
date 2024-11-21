package LAB5.Question1;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server address
        int port = 12345; // Server port number

        try (Socket socket = new Socket(hostname, port)) {
            // Get input and output streams
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send message to server
            writer.println("Hello Server!");

            // Read response from server
            String response = reader.readLine();
            System.out.println("Server responded: " + response);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
