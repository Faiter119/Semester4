package øving.opg0og1;

import data.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class CalculatorServer {


    public static void main(String[] args) throws IOException {

        int port = 1250;

        Calculator calculator = new Calculator();

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Server waiting for connection...");
            Socket socketConnection = serverSocket.accept(); // noen kobler til

            new Thread(() -> { // Egen klasse for en tråd? I don't wanna hear that

                try {
                    PrintWriter printWriter = new PrintWriter(socketConnection.getOutputStream(), true);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));

                    String line = bufferedReader.readLine();

                    while (!line.equals("")) {

                        double calculate = calculator.calculate(line);

                        System.out.println(calculate);
                        printWriter.println(calculate);

                        line = bufferedReader.readLine();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        }

    }

}
