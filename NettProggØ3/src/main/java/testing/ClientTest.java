package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {

        final int port = 1250;

        Socket socket = new Socket("localhost", port);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);


    /* Leser innledning fra tjeneren og skriver den til kommandovinduet */
        String innledning1 = bufferedReader.readLine();
        String innledning2 = bufferedReader.readLine();
        System.out.println(innledning1 + "\n" + innledning2);

        /*BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
*/
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        while (!line.equals("")){

            printWriter.println(line); // sender til server

            String answer = bufferedReader.readLine();
            System.out.println(answer);

            line = input.nextLine();
        }

    }
}
