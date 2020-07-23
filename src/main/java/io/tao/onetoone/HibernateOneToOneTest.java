package io.tao.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOneToOneTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        user.setVehicle(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        persisUsers(sessionFactory, user, vehicle);
    }

    private static void persisUsers(SessionFactory sessionFactory, Object... objects) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Object object: objects) {
            session.save(object);
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
