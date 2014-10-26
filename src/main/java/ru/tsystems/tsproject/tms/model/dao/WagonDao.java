package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Order;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * Created by Anton on 17.10.2014.
 */
public class WagonDAO extends AbstractDAO<Wagon> {
    /*public WagonDAO(EntityManager em){
        super(em);
    }*/

    public Wagon getWagon(long id){
        return em.find(Wagon.class, id);
    }

    public void delete(long id){
        em.remove(getWagon(id));
    }

    @Override
    public List<Wagon> getAll() {
        //TypedQuery<Wagon> namedQuery = em.createNamedQuery("Wagon.getAll", Wagon.class);
        Query namedQuery = em.createNativeQuery("SELECT * FROM wagon", Wagon.class);
        return namedQuery.getResultList();
    }

    public Object findOnRegNumber(String regNumber){
        //Wagon wagon = new Wagon();

        Query query = em.createQuery("SELECT e FROM Wagon e WHERE e.regNumber = :regNumber");
        query.setParameter("regNumber", regNumber);
        Object wgn = null;
        wgn= query.getSingleResult();
        return wgn;
    }

    public Object findGoodWagon(String classCapacity){
        Query query = em.createQuery("SELECT e FROM Wagon e WHERE e.classCapacity <= :classCapacity AND e.order = null");
        query.setParameter("classCapacity", classCapacity);
        Object wgn = null;
        wgn= query.getSingleResult();
        return wgn;
    }
}
