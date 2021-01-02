package app.client;

import app.core.utils.console;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP implements Runnable {
    @Override
    public void run() {
        console.log("Client udp is starting...");
        try {
            DatagramSocket socket = new DatagramSocket();
            int i = 8;
            byte[] b = String.valueOf(i).getBytes();

            InetAddress ia = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
            console.log("Send data...");
            socket.send(dp);
            console.log("Data were send");

            byte[] b1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
            console.log("Receive data...");
            socket.receive(dp1);
            console.log("Data received");

            String str = new String(dp1.getData());
            console.log("Result is: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
