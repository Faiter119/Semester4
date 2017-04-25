package øving.oppgave2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OlavH on 06-Mar-17.
 */
public class WebServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(80);

        System.out.println("Waiting for connection");
        Socket socket = serverSocket.accept();

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = bufferedReader.readLine();
        String header = "";

        while (!line.equals("")){

            System.out.println(line);
            header += "<li>"+line+"</li>";
            line = bufferedReader.readLine();

        }
        System.out.println("End of HTTP request");

        printWriter.println(
                "HTTP/1.0 200 OK\n"
                        + "Content-Type: text/html\n"
                        + "\n"
                        + "<HTML><BODY>\n"
                        + "<H1> Hilsen. Du har koblet deg opp til min enkle web-tjener </h1>\n"
                        + "Header fra klient er:\n"
                        + "<UL>\n"
                        + header+"\n"
                        + "</UL>\n"
                        + "</BODY></HTML>");


    }

}
