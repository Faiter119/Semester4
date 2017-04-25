package testing;

import POJO.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by OlavH on 27-Feb-17.
 */
public class WrongResultTest {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityManager entityManager2 = entityManagerFactory.createEntityManager();


    public static void main(String[] args) {


        /*entityManager.getTransaction().begin(); // removes all the trash
        entityManager.createQuery("from Account where accountNr > 2").getResultList().forEach(entityManager::remove);
        entityManager.getTransaction().commit();*/

        entityManager.getTransaction().begin();



        Account account1 = entityManager.createQuery("from Account where accountNr = 1", Account.class).getSingleResult();
        Account account2 = entityManager.createQuery("from Account where accountNr = 2", Account.class).getSingleResult();

        account1.setBalance(1000);
        account2.setBalance(1000);

        entityManager.getTransaction().commit();

        System.out.println(entityManager.createQuery("from Account").getResultList());

        new Thread(() -> {

            entityManager.getTransaction().begin();

                Account account = entityManager.createQuery("from Account where accountNr = 1", Account.class).getSingleResult();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.withdraw(1000);
                System.out.println(entityManager.createQuery("from Account").getResultList());

            entityManager.getTransaction().commit();

        }).run();

        new Thread(() -> {

            entityManager2.getTransaction().begin();

            Account account = entityManager.createQuery("from Account where accountNr = 1", Account.class).getSingleResult();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }


            account.withdraw(500);
            System.out.println(entityManager.createQuery("from Account").getResultList());

            entityManager2.getTransaction().begin();

        }).run();

        System.out.println(entityManager.createQuery("from Account").getResultList());

    }



}
/*
[Account{accountNr=1, balance=1000.0, ownerName='Olav Reppe Husby'}, Account{accountNr=2, balance=1000.0, ownerName='Magnus Hammer'}]
[Account{accountNr=1, balance=0.0, ownerName='Olav Reppe Husby'}, Account{accountNr=2, balance=1000.0, ownerName='Magnus Hammer'}]
[Account{accountNr=1, balance=-500.0, ownerName='Olav Reppe Husby'}, Account{accountNr=2, balance=1000.0, ownerName='Magnus Hammer'}]
[Account{accountNr=1, balance=-500.0, ownerName='Olav Reppe Husby'}, Account{accountNr=2, balance=1000.0, ownerName='Magnus Hammer'}]
*
* */
