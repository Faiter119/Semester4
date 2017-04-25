package eksempel;

import java.util.ArrayList;

/*
 * Klassen UtstyrImpl er mutabel. Antall pø lager og nedre grense for
 * bestilling kan endres.
 */
class Utstyr {

    public static final int bestillingsfaktor = 5;
    private int nr;  // entydig identifikasjon
    private String betegnelse;
    private String leverandør;
    private int pøLager;     // mengde pø lager
    private int nedreGrense;

    public Utstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) {

        nr = startNr;
        betegnelse = startBetegnelse;
        leverandør = startLeverandør;
        pøLager = startPøLager;
        nedreGrense = startNedreGrense;
    }

    public int finnNr() {

        return nr;
    }

    public String finnBetegnelse() {

        return betegnelse;
    }

    public String finnLeverandør() {

        return leverandør;
    }

    public int finnPøLager() {

        return pøLager;
    }

    public int finnNedreGrense() {

        return nedreGrense;
    }

    public int finnBestKvantum() {

        if (pøLager < nedreGrense) return bestillingsfaktor * nedreGrense;
        else return 0;
    }

    /*
     * Endringen kan vøre positiv eller negativ. Men det er ikke
     * mulig ø ta ut mer enn det som fins pø lager. Hvis klienten
     * prøver pø det, vil metoden returnere false, og intet uttak gjøres.
     */
    public boolean endreLagerbeholdning(int endring) {

        System.out.println("Endrer lagerbeholdning, utstyr nr " + nr + ", endring: " + endring);
        if (pøLager + endring < 0) return false;
        else {
            pøLager += endring;
            return true;
        }
    }

    public void settNedreGrense(int nyNedreGrense) {

        nedreGrense = nyNedreGrense;
    }

    public String toString() {

        String resultat = "Nr: " + nr + ", " + "Betegnelse: " + betegnelse + ", " + "Leverandør: " + leverandør + ", " + "Pø lager: " + pøLager + ", " + "Nedre grense: " + nedreGrense;
        return resultat;
    }
}

/*
 *
 * Et register holder orden pø en mengde Utstyrsobjekter. En klient kan legge inn nye
 * UtstyrImpl-objekter i registeret, og ogsø endre varebeholdningen for et
 * allerede registrert objekt. Bestillingsliste for alle varene kan lages.
 */
class Register {

    public static final int ok = -1;
    public static final int ugyldigNr = -2;
    public static final int ikkeNokPøLager = -3;

    private ArrayList<Utstyr> registeret = new ArrayList<Utstyr>();

    public boolean regNyttUtstyr(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense) {

        if (finnUtstyrindeks(startNr) < 0) { // fins ikke fra før
            Utstyr nytt = new Utstyr(startNr, startBetegnelse, startLeverandør, startPøLager, startNedreGrense);
            registeret.add(nytt);
            return true;
        }
        else return false;
    }

    public int endreLagerbeholdning(int nr, int mengde) {

        int indeks = finnUtstyrindeks(nr);
        if (indeks < 0) return ugyldigNr;
        else {
            if (!(registeret.get(indeks)).endreLagerbeholdning(mengde)) {
                return ikkeNokPøLager;
            }
            else return ok;
        }
    }

    private int finnUtstyrindeks(int nr) {

        for (int i = 0; i < registeret.size(); i++) {
            int funnetNr = (registeret.get(i)).finnNr();
            if (funnetNr == nr) return i;
        }
        return -1;
    }

    public String lagBestillingsliste() {

        String resultat = "\n\nBestillingsliste:\n";
        for (int i = 0; i < registeret.size(); i++) {
            Utstyr u = registeret.get(i);
            resultat += u.finnNr() + ", " + u.finnBetegnelse() + ": " + u.finnBestKvantum() + "\n";
        }
        return resultat;
    }

    public String lagDatabeskrivelse() {

        String resultat = "Alle data:\n";
        for (int i = 0; i < registeret.size(); i++) {
            resultat += (registeret.get(i)).toString() + "\n";
        }
        return resultat;
    }
}