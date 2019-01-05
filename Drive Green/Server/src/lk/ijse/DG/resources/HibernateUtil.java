package lk.ijse.DG.resources;

import lk.ijse.DG.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil   {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .loadProperties("Drive.properties")
                .build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Reception.class)
                .addAnnotatedClass(Tester.class)
                .addAnnotatedClass(Test.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
