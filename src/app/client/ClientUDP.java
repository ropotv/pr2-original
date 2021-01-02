package app.client;

import java.io.IOException;
import java.net.*;

public class ClientUDP implements Runnable {
    private final int port = 10000;
    private final InetAddress localhost;
    private final DatagramSocket socket;
    private final byte[] buffer = new byte[512];

    public ClientUDP() throws UnknownHostException, SocketException {
        this.localhost = InetAddress.getLocalHost();
        this.socket = new DatagramSocket();

    }

    @Override
    public void run() {
        System.out.println("Client UDP is starting...");
        DatagramPacket request = new DatagramPacket(this.buffer, this.buffer.length, this.localhost, port);

        try {
            this.socket.send(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
