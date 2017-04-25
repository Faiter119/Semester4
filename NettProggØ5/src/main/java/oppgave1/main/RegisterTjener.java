package oppgave1.main;

import oppgave1.implementations.factories.RegisterFactoryImpl;
import oppgave1.interfaces.data.Register;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by OlavH on 15-Mar-17.
 */
public class RegisterTjener {


    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        Register register = new RegisterFactoryImpl().makeRegister();
        String objektNavn = "Register";

        Naming.rebind(objektNavn, register);
        System.out.println("Register bindet");

        register.regNyttUtstyr(1,"ost","tine",5,1);
        register.regNyttUtstyr(2,"mat","gilde",10,5);
        register.regNyttUtstyr(3,"sko","falkanger",2,1);
        register.regNyttUtstyr(4,"pc","lenovo",1,1);
        register.regNyttUtstyr(5,"sykkel","trek",1,1);


        JOptionPane.showMessageDialog(null, "Klikk OK for å slå av server");

        Naming.unbind(objektNavn);

        System.exit(0); // ellers lukkes den ikke av en eller annen grunn
    }
}
