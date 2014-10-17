package ru.tsystems.tsproject.tms.model.dao;

import java.util.List;

/**
 * Created by Lena on 17.10.2014.
 */
public abstract class AbstractDao<T extends Entity> {
    public AbstractDao(){
        //сюда нужно передать jpa менеджер фактори
    }
    public abstract List<T> findAll();
    public abstract T findEntityById(long id);
    public abstract boolean delete(long id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);

}
