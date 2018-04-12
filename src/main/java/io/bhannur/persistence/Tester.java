package io.bhannur.persistence;

import javax.persistence.*;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
    // In JPA, two things 1. Entity ManagerFactory responsible for loading the jpa configuration from the XML. Connection is established based on parameters set.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example"); // Costly operation , we do it only once for application. Re-use again and again.

        // 2. EntityManager: Talk with JPA and make changes
        EntityManager em = emf.createEntityManager();

        Employee employee = new Employee();
        employee.setCity("Dearborn");
        employee.setEmail("sumanathD@gmail.com");
       // employee.setId("123456");
        employee.setName("SumanthD");
        employee.setSalary("5000");

        // Insert sand save data => Transaction
   /*     em.getTransaction().begin();
        em.persist(employee); // Using persist => similar to insert query
        em.getTransaction().commit();*/


   /*// Find One
        Employee existing = em.find(Employee.class, "44fbd8cb-0e7d-4a94-9f6d-c10058acaf31"); // invalid => null
        System.out.println(existing);
    // No need of transaction here.*/


 /*  // Update
        Employee existing = em.find(Employee.class, "44fbd8cb-0e7d-4a94-9f6d-c10058acaf31"); // invalid => null
        existing.setEmail("maheshb@gmail.com");
        em.getTransaction().begin();
        em.merge(existing); // merge to update the Row
        em.getTransaction().commit();
*/

 // Delete is kind of different, where you cannot delete by ID. we have to have entire object.
        // So find exiting employee by ID, because remove method takes only object as parameter.
/*
        Employee existing = em.find(Employee.class, "44fbd8cb-0e7d-4a94-9f6d-c10058acaf31"); // invalid => null
        em.getTransaction().begin();
        em.remove(existing);
        em.getTransaction().commit();

        */
        // Find All: In raw entity manager, JPA , we dont have a direct method but we can acheive it by generic way
        // i.e //  Java persistence Query Language (JPQL)
        // instead of taking directly with the database, we link with the instance of object.

        /*Query query = em.createQuery("SELECT e FROM Employee e ORDER BY e.email ASC "); // don not create native query as we will be binding to specific DB.
        List employeelist = query.getResultList();*/
        // ==> By use of Typed Query
     /*   TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ORDER BY e.email ASC ", Employee.class); // don not create native query as we will be binding to specific DB.
        List employeelist = query.getResultList();
        employeelist.stream()
                .forEach(emp -> System.err.println(emp));*/

     // FIND BY EMAIL
       /* TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.email =:pEmail" , Employee.class); // don not create native query as we will be binding to specific DB.
        query.setParameter("pEmail", "test2@gmail.com");
        List employeelist = query.getResultList();
        employeelist.stream()
                .forEach(emp -> System.err.println(emp));*/

        // Named query concept: put query related to entity in separate and use them by using the annotation
        // @NamedQueries(@NamedQuery(name="", query="")

       TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail" , Employee.class); // don not create native query as we will be binding to specific DB.
        query.setParameter("pEmail", "test2@gmail.com");
        List employeelist = query.getResultList();
        employeelist.stream()
                .forEach(emp -> System.err.println(emp));

        em.close();
        emf.close();

    }
}
