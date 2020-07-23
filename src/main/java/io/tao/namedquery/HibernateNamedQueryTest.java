package io.tao.namedquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

// Hibernate Tutorial 28 - Named Queries
public class HibernateNamedQueryTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // named query
//        Query query = session.getNamedQuery("UserDetails.byId");
//        query.setParameter("userId", 2);
//        List<UserDetails> users = (List<UserDetails>) query.list();

        // named native query
        Query query = session.getNamedNativeQuery("UserDetails.byName");
        query.setParameter("username", "User 2");
        List<UserDetails> users = (List<UserDetails>) query.list();

        session.getTransaction().commit();
        session.close();

        for (UserDetails user: users) {
            System.out.println(user);
        }
    }

}
