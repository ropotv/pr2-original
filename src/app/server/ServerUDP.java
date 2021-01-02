package app.server;

import app.core.config.AppConfig;
import app.core.utils.console;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
    public static void main(String[] args) throws Exception {
        console.log("Server Started");
        DatagramSocket socket = new DatagramSocket(AppConfig.Port);
        byte[] receiveBytes = new byte[1024];
        DatagramPacket datagramToReceive = new DatagramPacket(receiveBytes, receiveBytes.length);
        console.log("Waiting data to receive...");

        socket.receive(datagramToReceive);
        String str = new String(datagramToReceive.getData());
        console.log("Received number" + str);

        double result = Math.pow(Integer.parseInt(str.trim()), 2);

        byte[] sendBytes = String.valueOf(result).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket datagramToSend = new DatagramPacket(sendBytes, sendBytes.length, ia, datagramToReceive.getPort());
        socket.send(datagramToSend);
        console.log("Server send successfully value " + result);
    }
}
