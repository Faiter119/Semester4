package POJO;

import javax.persistence.*;

/**
 * Created by OlavH on 27-Feb-17.
 */

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNr;

    private double balance = 0; // double? rip
    private String ownerName;

    @Version
    private int version;

    public Account(String ownerName) {
        this.ownerName = ownerName;
    }

    public Account() {}

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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public double withdraw(double amount){

        if (amount >= 0 && amount >= balance){
            balance -= amount;
            return balance;
        }
        else throw new IllegalArgumentException("Illegal amount");

    }
    public void deposit(double amount){

        if (amount >= 0) {
            balance += amount;
        }

    }

    public void transferTo(Account account, double amount){

        if (balance >= amount) {
            balance -= amount;
            account.deposit(amount);
        }


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
        return "Account{" + "accountNr=" + accountNr + ", balance=" + balance + ", ownerName='" + ownerName + '\'' + ", version=" + version + '}';
    }
}
