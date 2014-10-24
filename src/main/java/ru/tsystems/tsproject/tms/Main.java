package ru.tsystems.tsproject.tms;

import ru.tsystems.tsproject.tms.model.employee.ControlDrivers;
import ru.tsystems.tsproject.tms.model.employee.ControlOrder;
import ru.tsystems.tsproject.tms.model.employee.ControlWagon;
import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import java.util.List;

/**
 * Created by Anton on 23.10.2014.
 */
public class Main {
    public static void main(String[] args){
        ControlOrder controlOrder = new ControlOrder();
        //ControlDrivers controlDrivers = new ControlDrivers();
        //ControlWagon controlWagon = new ControlWagon();
        System.out.println("OK1");
        //Driver driver = new Driver();
        Order order = new Order();
        //Wagon wagon = new Wagon();
        //***************************************
        /*driver.setFirstName("Roman");
        driver.setLastName("Romanov");
        driver.setPatronymic("Romanovich");
        driver.setLicenseNumber("cc12345");
        driver.setStatus("Not on shift");*/

        /*wagon.setRegNumber("aa12345");
        wagon.setNumberOfDriver(1);
        wagon.setClassCapacity("Small");
        wagon.setOrderNumber(null);
        wagon.setListOfDrivers(null);*/
        //*************************************
        order.setStatus("Created");
        order.setGpsCoordinates("111'2123'12313");
        order.setDeliveryStatus(false);
        order.setLoad("apple");
        order.setWeight(20);
        order.setWagon(null);
        System.out.println(order.toString());
        System.out.println("OK2");

        //List<Driver> list = controlDrivers.getListDriver();
        //System.out.println(list);
        //System.out.println(controlDrivers.findOnLN("aa12345"));


        //controlDrivers.addNewDriver(driver);
        controlOrder.addNewOrder(order);
        //controlWagon.addNewWagon(wagon);
        System.out.println("OK3");
    }
}
