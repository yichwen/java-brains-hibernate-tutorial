package io.tao.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCollectionTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        // no need explicitly set the user id, if it was annotated GeneratedValue
//        user.setUserId(1);
        user.setUserName("First User");

        Address addr1 = new Address();
        addr1.setStreet("First Street");
        addr1.setState("First State");
        addr1.setCity("First City");
        addr1.setPincode("10000");

        Address addr2 = new Address();
        addr2.setStreet("Second Street");
        addr2.setState("Second State");
        addr2.setCity("Second City");
        addr2.setPincode("20000");

        user.getAddresses().add(addr1);
        user.getAddresses().add(addr2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        persisUsers(sessionFactory, user);
        getUser(sessionFactory);
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
        // the following invocation will trigger another query to database to get addresses
        // this is called lazy initialization, only initialize the first level members
        // hibernate to do this via dynamic proxy to intercept the getter
        System.out.println("Addresses are " + user.getAddresses());
        session.getTransaction().commit();
        session.close();
    }
}
