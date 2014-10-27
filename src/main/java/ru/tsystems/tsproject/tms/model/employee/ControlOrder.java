package ru.tsystems.tsproject.tms.model.employee;


import ru.tsystems.tsproject.tms.model.dao.AbstractDAO;
import ru.tsystems.tsproject.tms.model.dao.OrderDAO;
import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
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
    public void addLoad(long orderNumber, String load){
        //получаем заказа с заданым номером orderNumber
        Order order;
        //order.setLoad("Load");
        //order.setStatus("Confirmed");
        //запись в базу
        //em.getTransaction().begin();
        OrderDAO ord = new OrderDAO();
        ord.beginTransaction();
        order = ord.getOrder(orderNumber);
        order.setLoad(load);
        order.setStatus("Confirmed");
        ord.update(order);
        //em.getTransaction().commit();
        ord.commitTransaction();

    }
    void appointWagon(long id){

        OrderDAO instance = new OrderDAO();
        Order order;
        instance.beginTransaction();
        order = instance.getOrder(id);

        String status = order.getStatus();
        if(!status.equalsIgnoreCase("Confirmed"))
            return;
        String classCapacity = getClassCapacity(order.getWeight());

        ControlWagon controlWagon = new ControlWagon();
        Wagon wagon = controlWagon.getGoodWagon(classCapacity);
        if(wagon == null)
            //нет подходящей фуры
            return;

        order.setWagon(wagon);
        //назначаем водителей в фуру
        List<Driver> driverList = new ArrayList<Driver>();
        ControlDrivers controlDrivers = new ControlDrivers();
        for(int i=0; i<wagon.getNumberOfDriver(); i++){
            Driver driver = controlDrivers.getFreeDriver();
            if (driver == null)
                return;//нет свободных водителей
            driverList.add(driver);
            driver.setStatus("On shift");
        }
        order.setStatus("Shipped");

        instance.commitTransaction();
        instance.close();
    }
    public void changeStatus(long id){
        OrderDAO instance = new OrderDAO();
        instance.beginTransaction();
        Order order;
        order = instance.getOrder(id);

        String status = order.getStatus();
        if(!status.equalsIgnoreCase("Executed"))
            return;

        Wagon wagon;
        wagon = order.getWagon();

        List<Driver> driverList = new ArrayList<Driver>();
        driverList = wagon.getListOfDrivers();

        for(int i=0; i < driverList.size(); i++){
            if(driverList.get(i).getStatus().equalsIgnoreCase("Driving"))
                return;//не можем сменить статус. есть водители за рулем
        }
        //меняем статус водителей
        for(int i=0; i < driverList.size(); i++){
            driverList.get(i).setStatus("Not on shift");
        }
        wagon.setListOfDrivers(null);//удаляем список водителей

        order.setWagon(null);

        order.setStatus("Closed");

        instance.commitTransaction();
        instance.close();

    }

    String getClassCapacity(int weight){
        String result = null;

        if(weight < 1000)
            result = "Small";
        else
            if(weight < 5000 && weight > 1000)
                result = "Medium";
            else
                if(weight < 10000 && weight > 5000)
                    result = "Large";

        return result;
    }
}
