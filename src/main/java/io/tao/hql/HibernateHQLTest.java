package io.tao.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

// Hibernate Tutorial 25 - Introducing HQL and Query Object
// Hibernate Tutorial 26 - Select and Pagination in HQL
// Hibernate Tutorial 27 - Understanding Parameter Binding and SQL Injection
public class HibernateHQLTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Simple HQL example
        // must be entity name, property name
//        Query query = session.createQuery("from UserDetails");
//        List<UserDetails> users = (List<UserDetails>) query.list();

        // Pagination example
//        Query query = session.createQuery("from UserDetails order by userId");
        // offset
//        query.setFirstResult(5);
        // limit
//        query.setMaxResults(4);
        // pagination by limit and offset
//        List<UserDetails> users = (List<UserDetails>) query.list();

        // Parameter Binding example
        String minUserId = "5";
//        Query query = session.createQuery("from UserDetails where userId > " + minUserId);    // security issue
//        Query query = session.createQuery("from UserDetails where userId > ?");     // deprecated
        // deprecated, position based
//        Query query = session.createQuery("from UserDetails where userId > ?1");
//        query.setInteger(1, Integer.parseInt(minUserId));

        Query query = session.createQuery("from UserDetails where userId > :userId");
        query.setParameter("userId", Integer.parseInt(minUserId));
        List<UserDetails> users = (List<UserDetails>) query.list();

        // other HQL example
        // "select new map(userId, userName) from UserDetails" will return list of map
//        query = session.createQuery("select userName from UserDetails");
//        List<String> userNames = (List<String>) query.list();

        session.getTransaction().commit();
        session.close();

        System.out.println("Size of list result = " + users.size());
        System.out.println("Users = " + users);

    }

}
