package io.tao.embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateEmbeddedTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();

        LogInName id = new LogInName();
        id.setUserId(1);
        id.setEmail("abc@mail.com");
        user.setUserId(id);
        user.setUserName("First User");

        Address address = new Address();
        address.setCity("City name");
        address.setState("State name");
        address.setStreet("Street name");
        user.setHomeAddress(address);

        Address officeAddress = new Address();
        officeAddress.setCity("Office City name");
        officeAddress.setState("Office State name");
        officeAddress.setStreet("Office Street name");
        user.setOfficeAddress(officeAddress);

        UserDetails user2 = new UserDetails();
        LogInName id2 = new LogInName();
        id2.setUserId(2);
        id2.setEmail("abc@mail.com");
        user2.setUserId(id2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        persisUsers(sessionFactory, user, user2);

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

}
