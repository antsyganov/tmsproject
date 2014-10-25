package ru.tsystems.tsproject.tms;

import ru.tsystems.tsproject.tms.model.driver.DriverService;
import ru.tsystems.tsproject.tms.model.employee.ControlDrivers;
import ru.tsystems.tsproject.tms.model.employee.ControlOrder;
import ru.tsystems.tsproject.tms.model.employee.ControlWagon;
import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 23.10.2014.
 */
public class Main {
    public static void main(String[] args){
        ControlOrder controlOrder = new ControlOrder();
        ControlDrivers controlDrivers = new ControlDrivers();
        ControlWagon controlWagon = new ControlWagon();
        System.out.println("OK1");
        Driver driver = new Driver();
        Order order = new Order();
        Wagon wagon = new Wagon();
        //Driver driver1 = new Driver();
        //***************************************
        /*driver.setFirstName("Rik");
        driver.setLastName("Rikov");
        driver.setPatronymic("Rikovich");
        driver.setLicenseNumber("ff12345");
        driver.setStatus("Not on shift");
        driver.setWagon(null);*/

        wagon.setRegNumber("ww12345");
        wagon.setNumberOfDriver(2);
        wagon.setClassCapacity("Small");
        //wagon.setOrderNumber(null);

        /*List list = new ArrayList<Driver>();
        list.add(driver);

        wagon.setListOfDrivers(list);

        List<Wagon> lw = new ArrayList<Wagon>();
        lw.add(wagon);
        driver.setWagon(lw);*/
        //*************************************
        /*order.setStatus("Created");
        order.setGpsCoordinates("111'2123'12313");
        order.setDeliveryStatus(false);
        order.setLoad("XYI");
        order.setWeight(30);
        order.setWagon(wagon);*/
        //System.out.println(driver.toString());
        System.out.println("OK2");

        /*List<Driver> list = new ArrayList<Driver>();
        list = controlDrivers.getListDriver();
        System.out.println(list);*/
        //System.out.println(controlWagon.findOnRN("aa12345"));

        /*List<Wagon> list = new ArrayList<Wagon>();
        list = controlWagon.getListWagon();
        System.out.println(list);*/


        /*List<Order> list = new ArrayList<Order>();
        list = controlOrder.getListOrder();
        System.out.println(list);*/

        //controlOrder.addLoad(3);

        DriverService driverService = new DriverService();
        driverService.changeStatusOfDriver(3, "On shift");

        //controlWagon.addNewWagon(wagon);
        //controlDrivers.addNewDriver(driver);
        //controlOrder.addNewOrder(order);
        //controlWagon.addNewWagon(wagon);
        System.out.println("OK3");
    }
}
