package oppgave1.implementations.factories;

import oppgave1.implementations.data.UtstyrImpl;
import oppgave1.interfaces.data.Utstyr;
import oppgave1.interfaces.factories.UtstyrFactory;

import java.rmi.RemoteException;

/**
 * Created by OlavH on 14-Mar-17.
 */
public class UtstyrFactoryImpl implements UtstyrFactory {

    @Override
    public Utstyr makeUtstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) throws RemoteException {

        return new UtstyrImpl(startNr, startBetegnelse, startLeverandør, startPøLager, startNedreGrense);
    }
}
