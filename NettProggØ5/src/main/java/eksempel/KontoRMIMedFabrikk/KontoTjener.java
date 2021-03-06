package eksempel.KontoRMIMedFabrikk;//
// Leksjon 2, katalog KontoRMIMedFabrikk
// KontoTjener.java E.L. 2005-02-02
//

import java.rmi.Naming;

class KontoTjener {

    public static void main(String[] args) throws Exception {

        Kontofabrikk fabrikk = new KontofabrikkImpl();
        String objektnavn = "Kontofabrikken";
        Naming.rebind(objektnavn, fabrikk); // NB, start rmiregistry i build/classes/main
        System.out.println("Fabrikkobjekt er registrert i rmi-registeret");

        javax.swing.JOptionPane.showMessageDialog(null, "Trykk OK for ø stoppe tjeneren.");

        Naming.unbind(objektnavn);

        System.exit(0);
    }
}
