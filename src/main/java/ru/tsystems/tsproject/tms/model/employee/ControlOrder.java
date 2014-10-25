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
    
    public List<Order> getListOrder(){
        List<Order> list;
        //em.getTransaction().begin();
        OrderDAO orders = new OrderDAO();
        orders.beginTransaction();
        list = orders.getAll();
        //em.getTransaction().commit();
        orders.commitTransaction();
        return list;
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
        dorder.close();
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
    public void addLoad(long orderNumber){
        //получаем заказа с заданым номером orderNumber
        Order order;
        //order.setLoad("Load");
        //order.setStatus("Confirmed");
        //запись в базу
        //em.getTransaction().begin();
        OrderDAO ord = new OrderDAO();
        ord.beginTransaction();
        order = ord.getOrder(orderNumber);
        order.setLoad("Load");
        order.setStatus("Confirmed");
        ord.update(order);
        //em.getTransaction().commit();
        ord.commitTransaction();

    }
    void appointWagon(Order order){
        String status = order.getStatus();
        if(!status.equalsIgnoreCase("Confirmed"))
            return;


    }
    void changeStatus(Order order){
        String status = order.getStatus();
        if(!status.equalsIgnoreCase("Performed"))
            return;

    }
}
