package io.bhannur.persistence.mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example"); // Costly operation , we do it only once for application. Re-use again and again.

        EntityManager em = emf.createEntityManager();

      /* Insert between entities
*/
      /*User user = new User();
        user.setName("Koundi");

        Address address = new Address();
        address.setCity("Detroit");
        address.setState("Michigan");

        em.getTransaction().begin();
        em.persist(address); // separate persistence because to avoid error on insertion.
        user.setAddress(address);
        em.persist(user);
        em.getTransaction().commit();*/

      // Find
     /* User user =  em.find(User.class, "8eb44b08-47c4-4308-ad51-fe15f72631b0");
        // trying to find the user detail, then JPA will internally query address table and provide data.
        System.err.println(user);*/

        em.close();
        emf.close();


    }
}
