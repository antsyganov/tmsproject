package ru.tsystems.tsproject.tms.model.employee;

import ru.tsystems.tsproject.tms.model.dao.AbstractDAO;
import ru.tsystems.tsproject.tms.model.dao.DriverDAO;
import ru.tsystems.tsproject.tms.model.dao.WagonDAO;
import ru.tsystems.tsproject.tms.model.entity.Driver;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Anton on 05.10.2014.
 */
public class ControlDrivers {
    protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();

    public List<Driver> getListDriver(){
        List<Driver> list;
        em.getTransaction().begin();
        AbstractDAO<Driver> drivers = new DriverDAO(em);
        list = drivers.getAll();
        em.getTransaction().commit();
        return list;
    }

    public void addNewDriver(){
        String licenseNumber;

        Driver driver = new Driver();

        em.getTransaction().begin();
        //добавление нового водителя в базу
        AbstractDAO<Driver> instance = new DriverDAO(em);
        instance.add(driver);
        em.getTransaction().commit();
    }

    public void addNewDriver(Driver driver){
        String licenseNumber;

        //Driver driver = new Driver();

        em.getTransaction().begin();
        //добавление нового водителя в базу
        AbstractDAO<Driver> instance = new DriverDAO(em);
        instance.add(driver);
        em.getTransaction().commit();
    }

    public boolean findOnLN(String licenseNumber){
        //Wagon wagon = new Wagon();

        em.getTransaction().begin();
        DriverDAO instance = new DriverDAO(em);
        Object ql = instance.findOnLicenseNumber(licenseNumber);
        em.getTransaction().commit();

        if(ql == null){
            return false;
        } else {
            return true;
        }
    }
}
