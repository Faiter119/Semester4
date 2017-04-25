package oppgave1.main;

import oppgave1.interfaces.data.Register;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by OlavH on 15-Mar-17.
 */
public class RegisterKlient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Register register = (Register) Naming.lookup("Register");
        System.out.println("Register found");

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        String input;

        do {
            //System.out.println(register.lagBestillingsliste());
            System.out.println(register.lagDatabeskrivelse());


            System.out.println("What item do you want to change? Input the ID: ");
            input = scanner.nextLine();

            if (!input.isEmpty()) {

                try {

                    int nr = Integer.parseInt(input);

                    System.out.println("Input amount to change: ");

                    String amountString = scanner.nextLine();

                    register.endreLagerbeholdning(nr, Integer.parseInt(amountString));

                }
                catch (Exception e) {
                    System.out.println("You wrote something invalid");
                }
            }

        }while (!input.equals("")); // første gangen jeg har hatt bruk for "do-while"

        System.out.println(register.lagBestillingsliste());


    }
}
