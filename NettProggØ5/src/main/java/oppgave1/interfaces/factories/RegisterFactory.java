package oppgave1.interfaces.factories;

import oppgave1.interfaces.data.Register;

import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 */
public interface RegisterFactory {

    Register makeRegister() throws RemoteException;

}