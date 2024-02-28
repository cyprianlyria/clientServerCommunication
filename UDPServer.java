import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        // Define the port number on which the server will listen
        int port = 9876;

        try {
            // Create a DatagramSocket to listen for incoming datagrams on the specified port
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("UDP Server is running and waiting for incoming datagrams on port " + port);

            // Create a byte array to hold the incoming data
            byte[] buffer = new byte[1024];

            // Create a DatagramPacket to store the incoming datagram
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Server will keep running to listen for incoming datagrams
            while (true) {
                // Receive the incoming datagram
                socket.receive(packet);

                // Extract the data from the packet
                String receivedData = new String(packet.getData(), 0, packet.getLength());

                // Display the received data
                System.out.println("Received from " + packet.getAddress() + ":" + packet.getPort() + " - " + receivedData);

                // Clear the buffer for the next iteration
                buffer = new byte[1024];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
