package io.tao.criteriaapi;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

// Hibernate Tutorial 29 - Criteria API
// Hibernate Tutorial 30 - Understanding Restrictions
// Hibernate Tutorial 31 - Projections and Query by Example
public class HibernateCriteriaApiTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // query by example
        UserDetails exampleUser = new UserDetails();
        exampleUser.setUserId(7);   // primary key and null value will be ignored
        exampleUser.setUserName("User 7");
        Example example = Example.create(exampleUser)
                // you can enable like here e.g. exampleUser.setUserName("User%");
                .enableLike()
                // you can exclude property here
                .excludeProperty("userName");

        // deprecated
        Criteria criteria = session.createCriteria(UserDetails.class)
                // query by example
                .add(example);
                // kind of select clause
//                .setProjection(Projections.property("userId")) // this will return List<String>
                // ordering
//                .addOrder(Order.desc("userId"));


        // add restrictions
//        criteria.add(Restrictions.eq("userName", "Updated user"))
//            .add(Restrictions.gt("userId", 5));

        List<UserDetails> users = (List<UserDetails>) criteria.list();

        session.getTransaction().commit();
        session.close();

        for (UserDetails user: users) {
            System.out.println(user);
        }
    }

}
