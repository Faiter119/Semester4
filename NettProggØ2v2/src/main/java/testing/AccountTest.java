package testing;

import POJO.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by OlavH on 27-Feb-17.
 */
public class AccountTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Account account1 = new Account("Olav Reppe Husby");
        account1.deposit(1000);
        Account account2 = new Account("Magnus Hammer");

        entityManager.getTransaction().begin();

            entityManager.persist(account1);
            entityManager.persist(account2);

            System.out.println(entityManager.find(Account.class, account1.getAccountNr()));
            System.out.println(entityManager.find(Account.class, account2.getAccountNr()));

            List resultList = entityManager.createQuery("from Account where balance > 100", Account.class).getResultList();
            System.out.println(resultList);

            System.out.println("-Etter Navneendring-");
            entityManager.find(Account.class, account1.getAccountNr()).setOwnerName("Endret Navn");
            resultList = entityManager.createQuery("from Account", Account.class).getResultList();
            System.out.println(resultList);

        entityManager.getTransaction().commit();


    }
}
