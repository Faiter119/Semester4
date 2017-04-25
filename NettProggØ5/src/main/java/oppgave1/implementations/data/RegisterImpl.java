package oppgave1.implementations.data;

import oppgave1.implementations.factories.UtstyrFactoryImpl;
import oppgave1.interfaces.data.Register;
import oppgave1.interfaces.data.Utstyr;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


/*
 *
 * Et register holder orden pø en mengde Utstyrsobjekter. En klient kan legge inn nye
 * UtstyrImpl-objekter i registeret, og ogsø endre varebeholdningen for et
 * allerede registrert objekt. Bestillingsliste for alle varene kan lages.
 */
public class RegisterImpl extends UnicastRemoteObject implements Register {

    public static final int ok = -1;
    public static final int ugyldigNr = -2;
    public static final int ikkeNokPøLager = -3;

    private List<Utstyr> registeret = new ArrayList<>();

    public RegisterImpl() throws RemoteException { // klekka ellers

    }

    public synchronized boolean regNyttUtstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) throws RemoteException {

        if (finnUtstyrindeks(startNr) < 0) { // fins ikke fra før
            Utstyr nytt = new UtstyrFactoryImpl().makeUtstyr(startNr, startBetegnelse, startLeverandør, startPøLager, startNedreGrense);
            registeret.add(nytt);
            return true;
        }
        else return false;
    }

    public synchronized int endreLagerbeholdning(int nr, int mengde) throws RemoteException {

        int indeks = finnUtstyrindeks(nr);
        if (indeks < 0) return ugyldigNr;
        else {
            if (!(registeret.get(indeks)).endreLagerbeholdning(mengde)) {
                return ikkeNokPøLager;
            }
            else return ok;
        }
    }

    private synchronized int finnUtstyrindeks(int nr) throws RemoteException {

        for (int i = 0; i < registeret.size(); i++) {
            int funnetNr = (registeret.get(i)).finnNr();
            if (funnetNr == nr) return i;
        }
        return -1;
    }

    public synchronized String lagBestillingsliste() throws RemoteException {

        String resultat = "\n\nBestillingsliste:\n";
        for (int i = 0; i < registeret.size(); i++) {
            Utstyr u = registeret.get(i);
            resultat += u.finnNr() + ", " + u.finnBetegnelse() + ": " + u.finnBestKvantum() + "\n";
        }
        return resultat;
    }

    public synchronized String lagDatabeskrivelse() throws RemoteException {

        String resultat = "Alle data:\n";
        for (int i = 0; i < registeret.size(); i++) {
            resultat += (registeret.get(i)).toString() + "\n";
        }
        return resultat;
    }
}