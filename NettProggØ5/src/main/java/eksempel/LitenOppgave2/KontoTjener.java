package eksempel.LitenOppgave2;

import java.rmi.Naming;

class KontoTjener {

    public static void main(String[] args) throws Exception {

        Konto olesKonto = new KontoImpl(123456676756L, "Ole Olsen", 2000);
        Naming.rebind("OleSinKonto", olesKonto);
        System.out.println("RMI-objekt er registrert");
    }
}
