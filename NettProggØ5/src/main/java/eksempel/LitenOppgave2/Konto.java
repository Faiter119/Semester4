package eksempel.LitenOppgave2;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface Konto extends Remote {

    long finnKontonr() throws RemoteException;

    String finnNavn() throws RemoteException;

    double finnSaldo() throws RemoteException;

    void gjørTransaksjon(double beløp) throws RemoteException;

    String lagUtskrift() throws RemoteException;
}

