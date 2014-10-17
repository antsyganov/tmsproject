package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Driver;

import java.util.List;

/**
 * Created by Lena on 17.10.2014.
 */
public class DriverDao extends AbstractDao<Driver> {

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public Driver findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Driver entity) {
        return false;
    }

    @Override
    public boolean create(Driver entity) {
        return false;
    }
}
