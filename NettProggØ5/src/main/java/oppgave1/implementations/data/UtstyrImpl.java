package oppgave1.implementations.data;

import oppgave1.interfaces.data.Utstyr;

/*
 * Klassen UtstyrImpl er mutabel. Antall pø lager og nedre grense for
 * bestilling kan endres.
 */
public class UtstyrImpl implements Utstyr {

    public static final int bestillingsfaktor = 5;
    private int nr;  // entydig identifikasjon
    private String betegnelse;
    private String leverandør;
    private int pøLager;     // mengde pø lager
    private int nedreGrense;



    public UtstyrImpl(int startNr, String startBetegnelse, String startLeverandør, int startPøLager, int startNedreGrense){

        nr = startNr;
        betegnelse = startBetegnelse;
        leverandør = startLeverandør;
        pøLager = startPøLager;
        nedreGrense = startNedreGrense;
    }


    public int finnNr(){

        return nr;
    }

    public String finnBetegnelse(){

        return betegnelse;
    }

    public String finnLeverandør(){

        return leverandør;
    }

    public int finnPøLager(){

        return pøLager;
    }

    public int finnNedreGrense(){

        return nedreGrense;
    }

    public int finnBestKvantum(){

        if (pøLager < nedreGrense) return bestillingsfaktor * nedreGrense;
        else return 0;
    }

    /*
     * Endringen kan vøre positiv eller negativ. Men det er ikke
     * mulig ø ta ut mer enn det som fins pø lager. Hvis klienten
     * prøver pø det, vil metoden returnere false, og intet uttak gjøres.
     */
    public boolean endreLagerbeholdning(int endring){

        System.out.println("Endrer lagerbeholdning, utstyr nr " + nr + ", endring: " + endring);
        if (pøLager + endring < 0) return false;
        else {
            pøLager += endring;
            return true;
        }
    }

    public void settNedreGrense(int nyNedreGrense){

        nedreGrense = nyNedreGrense;
    }

    public String toString() {

        String resultat = "Nr: " + nr + ", " + "Betegnelse: " + betegnelse + ", " + "Leverandør: " + leverandør + ", " + "Pø lager: " + pøLager + ", " + "Nedre grense: " + nedreGrense;
        return resultat;
    }
}