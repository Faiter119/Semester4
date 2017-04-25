package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class Testing {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(4444); // datagramSocket.bind(new InetSocketAddress(80)); // Samme

        System.out.println(1<<8);
        byte[] buffer = new byte[1<<8];
        DatagramPacket packet =new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet); // venter på at packet objektet skal motta info

        System.out.println(Arrays.toString(packet.getData()));




        //DatagramPacket datagramPacket = new DatagramPacket(new byte[2<<8], 10);
    }
}
