package io.tao.inheritance.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Hibernate Tutorial 20 - Inheritance with Joined Strategy
public class HibernateInheritanceJoinedTest {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche Steering Wheel");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        persist(sessionFactory, vehicle, bike, car);
    }

    private static void persist(SessionFactory sessionFactory, Object... objects) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Object object: objects) {
            session.save(object);
        }
        session.getTransaction().commit();
        session.close();
    }

}
