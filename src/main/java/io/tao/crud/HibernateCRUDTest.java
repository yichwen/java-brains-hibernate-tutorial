package io.tao.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Hibernate Tutorial 21 - CRUD Operations
public class HibernateCRUDTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // operation here

        // persist here
//        for (int i = 0; i < 10; i++) {
//            UserDetails user = new UserDetails();
//            user.setUserName("User " + i);
//            session.save(user);
//        }

        // read here
//        UserDetails user = session.get(UserDetails.class, 6);
//        System.out.println("User name pulled is: " +  user.getUserName());

        // read and delete
//        UserDetails user = session.get(UserDetails.class, 6);
//        session.delete(user);

        // read and update
        UserDetails user = session.get(UserDetails.class, 5);
        user.setUserName("Updated user");
        session.update(user);

        session.getTransaction().commit();
        session.close();

        // you still can access user here after read but not delete
//        System.out.println("User name pulled is: " +  user.getUserName());
    }

}
