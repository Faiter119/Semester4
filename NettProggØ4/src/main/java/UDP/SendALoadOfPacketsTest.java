package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class SendALoadOfPacketsTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        DatagramSocket datagramSocket = new DatagramSocket();


        while (true){


            DatagramPacket standardPacket = Standard.getStandardPacket();

            datagramSocket.send(standardPacket);

            Thread.sleep(10);
            System.out.println("Packets whooo");

        }

    }
}
