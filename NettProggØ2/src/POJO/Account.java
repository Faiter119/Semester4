package POJO;

/**
 * Created by OlavH on 27-Feb-17.
 */
public class Account {

    private long accountNr;
    private double balance = 0; // double? rip
    private String ownerName;


    public Account(long accountNr, String ownerName) {
        this.accountNr = accountNr;
        this.ownerName = ownerName;
    }

    public long getAccountNr() {
        return accountNr;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double withdraw(double amount){

        if (amount > 0 || amount > balance){
            balance -= amount;
            return balance;
        }
        else throw new IllegalArgumentException("Illegal amount");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNr != account.accountNr) return false;
        if (Double.compare(account.balance, balance) != 0) return false;
        return ownerName.equals(account.ownerName);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (accountNr ^ (accountNr >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ownerName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "POJO.Account{" + "accountNr=" + accountNr + ", ownerName='" + ownerName + '\'' + '}';
    }
}
