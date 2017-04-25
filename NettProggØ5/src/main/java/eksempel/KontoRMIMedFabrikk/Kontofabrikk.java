package eksempel.KontoRMIMedFabrikk;//
// Leksjon 2, katalog KontoRMIMedFabrikk
// Kontofabrikk.java E.L. 2003-09-04
//

import java.rmi.Remote;
import java.rmi.RemoteException;

interface Kontofabrikk extends Remote {

    Konto lagKonto(long startKontonr, String startNavn, double startSaldo) throws RemoteException;
}
