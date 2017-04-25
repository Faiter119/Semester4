package oppgave1.interfaces.data;

/**
 * Created by OlavH on 14-Mar-17.
 */
public interface Utstyr {

    int finnNr();

    String finnBetegnelse();

    String finnLeverandør();

    int finnPøLager();

    int finnNedreGrense();

    int finnBestKvantum();

    boolean endreLagerbeholdning(int endring);

    void settNedreGrense(int nyNedreGrense);
}
