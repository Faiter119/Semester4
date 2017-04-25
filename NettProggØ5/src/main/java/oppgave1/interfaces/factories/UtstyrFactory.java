package oppgave1.interfaces.factories;

import oppgave1.interfaces.data.Utstyr;

import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 * Tror egentlig ikke factory interfaces var nødvendig
 */
public interface UtstyrFactory {

    Utstyr makeUtstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) throws RemoteException;

}
