package io.tao.object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Hibernate Tutorial 22 - Transient, Persistent, and Detached Objects
// Hibernate Tutorial 24 - Persisting Detached Objects
public class HibernateObjectTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("Test user");
        // before save is considered transient object

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        // after save is considered persist object

        // auto-update is here before session close
        user.setUserName("Updated user");
        // hibernate is smart to perform least number of steps to update
        // only update one time
        user.setUserName("Updated user again");

        session.getTransaction().commit();
        session.close();

        // object become detached, no more auto-update

        user.setUserName("Updated username after session closed");
        // persist detached object here
        session = sessionFactory.openSession();
        session.beginTransaction();
        // will always go update even it is not changed, hibernate does not know what is changed
        session.update(user);
        // back to persist object
        session.getTransaction().commit();
        session.close();


    }

}
