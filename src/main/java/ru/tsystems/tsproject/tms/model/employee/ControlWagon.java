package ru.tsystems.tsproject.tms.model.employee;

import ru.tsystems.tsproject.tms.model.dao.AbstractDAO;
import ru.tsystems.tsproject.tms.model.dao.WagonDAO;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * Created by Anton on 04.10.2014.
 */
public class ControlWagon {
    //protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();

    public List<Wagon> getListWagon(){
        List<Wagon> list;
        //em.getTransaction().begin();

        WagonDAO wagon = new WagonDAO();
        wagon.beginTransaction();
        list = wagon.getAll();

        //em.getTransaction().commit();
        wagon.commitTransaction();

        return list;
    }

    public void addNewWagon(Wagon wagon){
        //em.getTransaction().begin();
        WagonDAO instance = new WagonDAO();
        instance.beginTransaction();
        instance.add(wagon);
        //em.getTransaction().commit();
        instance.commitTransaction();
        instance.close();
    }
    public void addNewWagon(){
        Wagon wagon = new Wagon();
        //запись новой фуры в базу

        //em.getTransaction().begin();
        WagonDAO instance = new WagonDAO();
        instance.beginTransaction();
        instance.add(wagon);
        //em.getTransaction().commit();
        instance.commitTransaction();
    }
    public boolean findOnRN(String regNumber){
        //Wagon wagon = new Wagon();

        //em.getTransaction().begin();
        WagonDAO instance = new WagonDAO();
        instance.beginTransaction();
        Object ql = instance.findOnRegNumber(regNumber);
        //em.getTransaction().commit();
        instance.commitTransaction();

        if(ql == null){
            return false;
        } else {
            return true;
        }
    }
}
