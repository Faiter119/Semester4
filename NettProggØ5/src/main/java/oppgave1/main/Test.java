package oppgave1.main;

import oppgave1.implementations.factories.RegisterFactoryImpl;
import oppgave1.implementations.factories.UtstyrFactoryImpl;
import oppgave1.interfaces.data.Register;
import oppgave1.interfaces.data.Utstyr;

import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 */
public class Test {

    public static void main(String[] args) throws RemoteException {

        Register register = new RegisterFactoryImpl().makeRegister();

        Utstyr utstyr = new UtstyrFactoryImpl().makeUtstyr(1,"ost","tine",5,1);


        System.out.println(register);

        System.out.println(utstyr);



    }

}
