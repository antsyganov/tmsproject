package ru.tsystems.tsproject.tms.model.driver;


import ru.tsystems.tsproject.tms.model.dao.DriverDAO;
import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Order;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lena on 05.10.2014.
 */
public class DriverService {
    public String getCurOrderInfo(long id){
        //необходимо получить водителя по указанному личному номеру licenseNumber
        //Driver driver = new Driver();
        //driver.
        String info;

        Driver driver;
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.beginTransaction();

        driver = driverDAO.getDriver(id);

        if(driver == null)
            return "Not exist"; //нет водителя с такими правами

        info = "Your ID: " + Long.toString(id) + ";";
        //Wagon wagon = driver.getWagon();

        List<Wagon> wagon = new ArrayList<Wagon>();
        wagon = driver.getWagon();

        info = info + "Reg Number Of Wagon: " + wagon.get(0).getRegNumber() + ";";

        List<Order> orderList = new ArrayList<Order>();
        orderList = wagon.get(0).getOrder();

        info = info + "Number of Order: " + orderList.get(0).getUniqueNumber() + ";";
        info = info + "GPS coord: " + orderList.get(0).getGpsCoordinates()
                    + "Load: " + orderList.get(0).getLoad()
                    + "Weight of load: " + orderList.get(0).getWeight()
                    + "Delivery status: " + orderList.get(0).getDeliveryStatus();

        driverDAO.commitTransaction();

        return info;
    }

    public void changeStatusOfDelivery(long id){
        Driver driver;
        List<Wagon> wagonlst = new ArrayList<Wagon>();
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.beginTransaction();
        driver = driverDAO.getDriver(id);

        //System.out.println(driver);
        wagonlst = driver.getWagon();

        //System.out.println(wagonlst);

        Wagon wagon = wagonlst.get(0);
        //System.out.println(wagon);

        Order order;
        List<Order> orderList = new ArrayList<Order>();
        orderList = wagon.getOrder();
        //System.out.println(orderList.size());

        order = orderList.get(0);
        order.setDeliveryStatus(true);
        order.setStatus("Executed");

        driverDAO.commitTransaction();

    }

    public boolean changeStatusOfDriver(long driverId, String status){
        Driver driver = new Driver();
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.beginTransaction();
        System.out.println("1");
        driver = driverDAO.getDriver(driverId);
        //driverDAO.commitTransaction();
        System.out.println("2");

        if(driver == null)
            //нет такого водителя!
            return false;
        System.out.println("3");

        if(driver.getStatus() == status)
            //статусы совпадают
            return false;
        System.out.println("4");

        //Wagon wagon = driver.getWagon();
        List<Wagon> wagon = driver.getWagon();
        System.out.println("5");

        if(wagon.get(0).getOrder() == null)
            //не можем сменить статус. не вылоняет ни одни заказ
            return false;
        System.out.println("6");
        if(wagon.get(0).getNumberOfDriver() == 1)
            driver.setStatus(status); //поменяли статус. водитель всего один
        else {
            if(status.equalsIgnoreCase("Shift"))
                driver.setStatus(status);
            else {
                List<Driver> ld = wagon.get(0).getListOfDrivers();
                for(int i =0; i< ld.size(); i++)
                    if(ld.get(i).getStatus().equalsIgnoreCase("Driving"))
                        return false; //не можем изменить статус, уже есть водитель за рулем

                driver.setStatus(status);//меняем статус водителя на "За рулем", поскольку нет другого водителя за рулем
            }
        }
        driverDAO.commitTransaction();
        return true;
    }
}
