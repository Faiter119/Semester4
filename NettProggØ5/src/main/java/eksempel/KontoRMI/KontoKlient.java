package eksempel.KontoRMI;//
// Leksjon 2, katalog KontoRMI
// KontoKlient.java - E.L. 2005-02-02
//

import java.rmi.Naming;

import static javax.swing.JOptionPane.showInputDialog;

class KontoKlient {

    public static void main(String[] args) throws Exception {

        // Dersom rmi-registeret og tjenerprogrammet kjører pø en annen maskin, mø IP-adressen eller
        // maskinnavnet settes inn i stedet for localhost pø neste linje.
        Konto olesKonto = (Konto) Naming.lookup("rmi://localhost/OleSinKonto");

        System.out.println("Kontonr: " + olesKonto.finnKontonr() + ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());

        String beløpLest = showInputDialog("Oppgi beløp, avslutt med blank");
        while (!beløpLest.equals("")) {
            double beløp = Double.parseDouble(beløpLest); //ingen feilkontroll
            olesKonto.gjørTransaksjon(beløp);
            System.out.println("Kontonr: " + olesKonto.finnKontonr() + ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());
            beløpLest = showInputDialog("Oppgi beløp, avslutt med blank");
        }
    }
}