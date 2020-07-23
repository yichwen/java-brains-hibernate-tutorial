package io.tao.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOneToManyTest {

    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        user.getVehicles().add(vehicle);
        vehicle.setUser(user);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");
        // you can combine the following two operations in one method, so no need two steps here
        user.getVehicles().add(vehicle2);
        vehicle2.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // without cascading configuration, by default vehicle must be saved else user persistence will fail
        // because vehicle is an entity, hibernate cannot make assumption
        // unless vehicle is value type, you can refer to value type as address at collection package
//        persistUsers(sessionFactory, user, vehicle, vehicle2);

        // if in UserDetails, there is a CascadeType.PERSIST, no vehicle need to save manually
        persistUsers(sessionFactory, user);
    }

    private static void persistUsers(SessionFactory sessionFactory, Object... objects) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Object object: objects) {
            session.persist(object);
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
