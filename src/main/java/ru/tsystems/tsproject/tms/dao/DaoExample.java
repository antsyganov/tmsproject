package ru.tsystems.tsproject.tms.dao;

import org.hibernate.Session;
import ru.tsystems.tsproject.tms.entity.Order;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Lena on 14.10.2014.
 */
public class DaoExample {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

}
