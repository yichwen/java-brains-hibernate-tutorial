package io.tao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// base hibernate test
public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("First User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        persisUsers(sessionFactory, user);
    }

    private static void persisUsers(SessionFactory sessionFactory, UserDetails... users) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (UserDetails user: users) {
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void getUser(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user = session.get(UserDetails.class, 1);
        System.out.println("User Name retrieved is " + user.getUserName());
        session.getTransaction().commit();
        session.close();
    }
}
