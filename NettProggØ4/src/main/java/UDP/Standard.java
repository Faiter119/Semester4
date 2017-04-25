package UDP;

import java.net.*;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class Standard {

    private Standard(){throw new IllegalArgumentException("No instance");}

    public static final int PORT = 4445;

    private static DatagramSocket socket; // singelton basically
    public static DatagramSocket getStandardSocket(){
        try {
            if (socket == null) {
                socket = new DatagramSocket();
            }
            return socket;
        }
        catch (SocketException e){
            e.printStackTrace();
            throw new RuntimeException("");}

    }

    public static DatagramPacket getStandardPacket() throws UnknownHostException {

        byte[] buffer = new byte[1<<8];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        packet.setAddress(InetAddress.getByName("localhost"));//getStandardSocket().getInetAddress());
        packet.setPort(PORT);

        /*System.out.println(packet.getPort());
        System.out.println(packet.getAddress());*/

        return packet;

    }
}
