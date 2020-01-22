/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.BikeDTO;
import entities.Bike;
import entities.Member;
import entities.Rental;
import entities.Storage;
import errorhandling.NotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jojus1101
 */
public class BikeFacade {

    private static BikeFacade instance;
    private static EntityManagerFactory emf;

    private BikeFacade() {
    }

    public static BikeFacade getBikeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BikeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<BikeDTO> getBikeList() {
        EntityManager em = getEntityManager();

        List<BikeDTO> bikesDTO = new ArrayList();

        TypedQuery<Bike> query = em.createQuery("SELECT b FROM Bike b", Bike.class);
        List<Bike> bikes = query.getResultList();

        for (Bike bike : bikes) {
            bikesDTO.add(new BikeDTO(bike));
        }

        return bikesDTO;

    }
    public BikeDTO addBike(BikeDTO bikeDTO) {
        Bike bike = new Bike(bikeDTO);

        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bike);
            em.getTransaction().commit();
            return new BikeDTO(bike);
        } finally {
            em.close();
        }
    }

    public void PopulateDB() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Bike.deleteAllRows").executeUpdate();
            em.createNamedQuery("Rental.deleteAllRows").executeUpdate();
            em.createNamedQuery("Member.deleteAllRows").executeUpdate();
            em.createNamedQuery("Storage.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
            
            Bike b1;
            Bike b2;
            Bike b3;
            Bike b4;
            
            Rental r1;
            Rental r2;
            Rental r3;
            Rental r4;
            
            Member m1;
            Member m2;
            Member m3;
            Member m4;
            
            Storage s1;
            Storage s2;
            
            b1 = new Bike("cannondale", "M", "male", 3, 100);
            b2 = new Bike("trek", "L", "male", 1, 80);
            b3 = new Bike("specialized", "S", "male", 3, 120);
            b4 = new Bike("cannondale", "M", "male", 32, 500);
            
            r1 = new Rental("24-01-2020");
            r2 = new Rental("24-02-2020");
            r3 = new Rental("24-03-2020");
            r4 = new Rental("24-04-2020");
            
            m1 = new Member("Carsten", "23-01-2015", "123jj3123");
            m2 = new Member("Niels", "20-02-2014", "1231hklahs22");
            m3 = new Member("John", "28-03-2017", "hiehf1123ffn");
            m4 = new Member("Hans", "30-04-2019", "hfihel2314hfh");
            
            s1 = new Storage("Storvej 30", 2000);
            s2 = new Storage("Storvej 31", 1500);
            

            em.getTransaction().begin();
            System.out.println("Saved test data to database");
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
