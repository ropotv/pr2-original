package app.client;

import app.core.config.AppConfig;
import app.core.utils.console;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws Exception {
        console.log("Launch Client");

        DatagramSocket socket = new DatagramSocket();
        InetAddress localHost = InetAddress.getLocalHost();
        byte[] receiveBytes = new byte[1024];
        DatagramPacket datagramToReceive = new DatagramPacket(receiveBytes, receiveBytes.length);

        console.log("Enter a number you want to square:");

        byte[] input = new Scanner(System.in).nextLine().getBytes();

        DatagramPacket datagramToSend = new DatagramPacket(input, input.length, localHost, AppConfig.Port);
        console.log("Send data to server");
        socket.send(datagramToSend);

        socket.receive(datagramToReceive);

        String str = new String(datagramToReceive.getData());
        console.log("Received data from server: " + str);
    }
}
