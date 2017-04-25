package oppgave1.implementations.factories;

import oppgave1.implementations.data.RegisterImpl;
import oppgave1.interfaces.data.Register;
import oppgave1.interfaces.factories.RegisterFactory;

import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 */
public class RegisterFactoryImpl implements RegisterFactory {


    @Override
    public Register makeRegister() throws RemoteException {

        return new RegisterImpl();
    }
}
