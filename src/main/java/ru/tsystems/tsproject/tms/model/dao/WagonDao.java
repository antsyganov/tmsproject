package ru.tsystems.tsproject.tms.model.dao;

import ru.tsystems.tsproject.tms.model.entity.Wagon;

import java.util.List;

/**
 * Created by Lena on 17.10.2014.
 */
public class WagonDao extends AbstractDao<Wagon> {

    @Override
    public List<Wagon> findAll() {
        return null;
    }

    @Override
    public Wagon findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Wagon entity) {
        return false;
    }

    @Override
    public boolean create(Wagon entity) {
        return false;
    }
}
