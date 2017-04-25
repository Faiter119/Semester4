package UDP;

import data.Calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(4445); // må si port på server, ikke klient

        Calculator calculator = new Calculator();

        while (true){

            DatagramPacket receivedPacket = Standard.getStandardPacket();

            System.out.println("Waiting for packet..");
            socket.receive(receivedPacket); // waits for data

            System.out.println(receivedPacket.getPort()+" - "+receivedPacket.getAddress());
            System.out.println(new String(receivedPacket.getData()));

            //Calculation

            double calculate = calculator.calculate(new String(receivedPacket.getData()));
            String answer = String.valueOf(calculate);

            DatagramPacket answerPacket = new DatagramPacket(answer.getBytes(), answer.getBytes().length, receivedPacket.getAddress(), receivedPacket.getPort());
            socket.send(answerPacket);



        }

    }

}
