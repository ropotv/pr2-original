package app.server;

import app.core.utils.console;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
    public static void main(String[] args) throws Exception {

        console.log("Server running...");
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] b1 = new byte[1024];

        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        console.log("Server receive...");
        socket.receive(dp);
        String str = new String(dp.getData());
        console.log("Received " + str);
        int num = Integer.parseInt(str.trim());
        int result = num * num;

        byte[] b2 = String.valueOf(result).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
        console.log("Server send " + result);
        socket.send(dp1);
        console.log("Send successfully");


    }
}
