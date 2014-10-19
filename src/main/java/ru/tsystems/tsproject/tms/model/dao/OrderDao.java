package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Anton on 17.10.2014.
 */
public class OrderDAO extends AbstractDAO<Order> {
    public OrderDAO(EntityManager em){
        super(em);
    }
    public Driver getOrder(long id){
        //em.getTransaction().begin();
        //em.getTransaction().commit();
        return em.find(Driver.class, id);
    }
    /*public List<Order> getAllDriver(){
        TypedQuery<Order> namedQuery = em.createNamedQuery("Order.getAll", Order.class);
        return namedQuery.getResultList();
    }*/
    public void delete(long id){
        //em.getTransaction().begin();
        em.remove(getOrder(id));
        //em.getTransaction().commit();
    }

    @Override
    public List<Order> getAll() {
        //TypedQuery<Order> namedQuery = em.createNamedQuery("Order.getAll", Order.class);
        Query namedQuery = em.createNativeQuery("SELECT * FROM order", Order.class);
        return namedQuery.getResultList();
    }
}
