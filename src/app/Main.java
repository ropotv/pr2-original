package app;

import app.client.ClientUDP;

import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        // write your code here
        ClientUDP client = new ClientUDP();
        client.run();

    }
}
