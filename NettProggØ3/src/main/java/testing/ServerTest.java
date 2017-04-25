package testing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class ServerTest {

    public static void main(String[] args) throws IOException {

        final int port = 1250;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("server startet, venter på forbindelse");

        Socket socket = serverSocket.accept(); // når noen kobler til

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

    /* Sender innledning til klienten */
        printWriter.println("Hei, du har kontakt med tjenersiden!");
        printWriter.println("Skriv hva du vil, så skal jeg gjenta det, avslutt med linjeskift.");


        String line = bufferedReader.readLine();
        while (!line.equals("")){

            System.out.println(line+" gotten");
            printWriter.println("Du skrev: "+line);

            line = bufferedReader.readLine();
        }

    }

}
