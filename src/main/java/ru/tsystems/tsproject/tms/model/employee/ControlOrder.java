package ru.tsystems.tsproject.tms.model.employee;


import ru.tsystems.tsproject.tms.model.dao.AbstractDAO;
import ru.tsystems.tsproject.tms.model.dao.OrderDAO;
import ru.tsystems.tsproject.tms.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Anton on 05.10.2014.
 */
public class ControlOrder {
    protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();
    
    void getListOrder(){
        List<Order> list;
        em.getTransaction().begin();
        AbstractDAO<Order> orders = new OrderDAO(em);
        list = orders.getAll();
        em.getTransaction().commit();
    }
    void addNewOrder(){
        Order newOrder = new Order();
        //необходимо сгенерировать новый номер заказа
        newOrder.setStatus("Created");
        //запись нового заказа в базу
        em.getTransaction().begin();
        AbstractDAO<Order> order = new OrderDAO(em);
        order.add(newOrder);
        em.getTransaction().commit();
    }
    void addLoad(String orderNumber){
        //получаем заказа с заданым номером orderNumber
        Order order = new Order();
        order.setLoad("Load");
        order.setStatus("Confirmed");
        //запись в базу
        em.getTransaction().begin();
        AbstractDAO<Order> ord = new OrderDAO(em);
        ord.update(order);
        em.getTransaction().commit();

    }
    void appointWagon(){

    }
    void changeStatus(){

    }
}
