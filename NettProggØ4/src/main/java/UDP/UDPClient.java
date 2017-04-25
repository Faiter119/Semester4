package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        DatagramSocket datagramSocket = new DatagramSocket();


        System.out.println("Input data: ");
        String line = scanner.nextLine();

        while (!line.equals("")){

            DatagramPacket toSendPacket = Standard.getStandardPacket(); // adresse og port i packet
            toSendPacket.setData(line.getBytes());


            datagramSocket.send(toSendPacket); // sends packet


            DatagramPacket receivedPacket = Standard.getStandardPacket();

            System.out.println("Waiting for answer..");
            datagramSocket.receive(receivedPacket); // waits for data

            System.out.println(new String(receivedPacket.getData()));


            line = scanner.nextLine();
        }
    }
}
