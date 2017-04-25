package øving.opg0og1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class CalculatorClient {

    public static void main(String[] args) throws IOException {

        int port = 1250;

        Socket socket = new Socket("localhost",port);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Input your math expression: ");
        String input = keyboardInput.nextLine();

        while (!input.equals("")){

            printWriter.println(input); // sends to server

            String answer = bufferedReader.readLine();

            System.out.println("Svaret er: "+answer);

            input = keyboardInput.nextLine();
        }

    }

}
