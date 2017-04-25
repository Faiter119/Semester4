package oppgave1.interfaces.data;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 */
public interface Register extends Remote {

    boolean regNyttUtstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) throws RemoteException;

    int endreLagerbeholdning(int nr, int mengde) throws RemoteException;

    String lagBestillingsliste() throws RemoteException;

    String lagDatabeskrivelse() throws RemoteException;
}
