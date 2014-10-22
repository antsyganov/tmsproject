package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Anton on 17.10.2014.
 */
public class DriverDAO extends AbstractDAO<Driver> {
    //public DriverDAO(EntityManager em){
        //super(em);
    //}

    public Driver getDriver(long id){
        //em.getTransaction().begin();
        //em.getTransaction().commit();
        return em.find(Driver.class, id);
    }
    /*public List<Driver> getAllDriver(){
        TypedQuery<Driver> namedQuery = em.createNamedQuery("Driver.getAll", Driver.class);
        return namedQuery.getResultList();
    }*/
    public void delete(long id){
        //em.getTransaction().begin();
        em.remove(getDriver(id));
        //em.getTransaction().commit();
    }

    @Override
    public List<Driver> getAll() {
        //TypedQuery<Driver> namedQuery = em.createNamedQuery("Driver.getAll", Driver.class);
        Query namedQuery = em.createNativeQuery("SELECT * FROM driver", Driver.class);
        return namedQuery.getResultList();
    }

    public Driver findOnLicenseNumber(String licenseNumber){
        //Wagon wagon = new Wagon();

        Query query = em.createQuery("SELECT e FROM driver e WHERE e.licenseNumber = :licenseNumber");
        query.setParameter("licenseNumber", licenseNumber);
        //Object wgn = null;
        Driver driver = null;
        driver = (Driver)query.getSingleResult();
        return driver;
    }
}
