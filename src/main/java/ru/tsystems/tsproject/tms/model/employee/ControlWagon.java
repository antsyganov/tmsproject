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
    protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();

    public List<Wagon> getListWagon(){
        List<Wagon> list;
        em.getTransaction().begin();

        AbstractDAO<Wagon> wagon = new WagonDAO(em);
        list = wagon.getAll();

        em.getTransaction().commit();

        return list;
    }

    public void addNewWagon(Wagon wagon){
        em.getTransaction().begin();
        AbstractDAO<Wagon> instance = new WagonDAO(em);
        instance.add(wagon);
        em.getTransaction().commit();
    }
    public void addNewWagon(){
        Wagon wagon = new Wagon();
        //запись новой фуры в базу

        em.getTransaction().begin();
        AbstractDAO<Wagon> instance = new WagonDAO(em);
        instance.add(wagon);
        em.getTransaction().commit();
    }
    public boolean findOnRN(String regNumber){
        //Wagon wagon = new Wagon();

        em.getTransaction().begin();
        WagonDAO instance = new WagonDAO(em);
        Object ql = instance.findOnRegNumber(regNumber);
        em.getTransaction().commit();

        if(ql == null){
            return false;
        } else {
            return true;
        }
    }
}
