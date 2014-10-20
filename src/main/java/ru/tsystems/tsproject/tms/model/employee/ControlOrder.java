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
    //protected EntityManager em = Persistence.createEntityManagerFactory("tms_db").createEntityManager();
    
    public void getListOrder(){
        List<Order> list;
        //em.getTransaction().begin();
        OrderDAO orders = new OrderDAO();
        orders.beginTransaction();
        list = orders.getAll();
        //em.getTransaction().commit();
        orders.commitTransaction();
    }
    public void addNewOrder(Order order){
        //Order newOrder = new Order();
        //необходимо сгенерировать новый номер заказа
        order.setStatus("Created");
        //запись нового заказа в базу
        //em.getTransaction().begin();
        OrderDAO dorder = new OrderDAO();
        dorder.beginTransaction();
        dorder.add(order);
        //em.getTransaction().commit();
        dorder.commitTransaction();
    }

    public void addNewOrder(){
        Order newOrder = new Order();
        //необходимо сгенерировать новый номер заказа
        newOrder.setStatus("Created");
        //запись нового заказа в базу
        //em.getTransaction().begin();
        OrderDAO order = new OrderDAO();
        order.beginTransaction();
        order.add(newOrder);
        //em.getTransaction().commit();
        order.commitTransaction();
    }
    public void addLoad(String orderNumber){
        //получаем заказа с заданым номером orderNumber
        Order order = new Order();
        order.setLoad("Load");
        order.setStatus("Confirmed");
        //запись в базу
        //em.getTransaction().begin();
        OrderDAO ord = new OrderDAO();
        ord.beginTransaction();
        ord.update(order);
        //em.getTransaction().commit();
        ord.commitTransaction();

    }
    void appointWagon(){

    }
    void changeStatus(){

    }
}
