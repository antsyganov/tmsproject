package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Entities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

/**
 * Created by Anton on 17.10.2014.
 */
public abstract class AbstractDAO<T extends Entities> {
    protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();

    //public AbstractDAO(EntityManager em){
        //this.em = em;
    //}

    public void add(T entity){
        //em.getTransaction().begin();
        em.persist(entity);
        //em.getTransaction().commit();
    }
    /*public T get(long id){
        return em.find(T.class, id);
    }*/
    public void update(T entity){
        em.merge(entity);
    }
    public void delete(T entity){
        em.remove(entity);
    }
    public abstract List<T> getAll();

    public void  beginTransaction(){
        em.getTransaction().begin();
    }
    public void commitTransaction(){
        em.getTransaction().commit();
    }


}
