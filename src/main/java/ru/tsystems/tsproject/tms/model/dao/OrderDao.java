package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Order;

import java.util.List;

/**
 * Created by Lena on 17.10.2014.
 */
public class OrderDao extends AbstractDao<Order> {

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }
}
