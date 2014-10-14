package ru.tsystems.tsproject.tms.employee;


import ru.tsystems.tsproject.tms.entity.Order;

/**
 * Created by Lena on 05.10.2014.
 */
public class ControlOrder {
    void getListOrder(){

    }
    void addNewOrder(){
        Order newOrder = new Order();
        //необходимо сгенерировать новый номер заказа
        newOrder.setStatus("Created");
    }
    void addLoad(String orderNumber){
        //получаем заказа с заданым номером orderNumber
        Order order = new Order();
        order.setLoad("Load");
        order.setStatus("Confirmed");
    }
    void appointWagon(){

    }
    void changeStatus(){

    }
}
