package ru.tsystems.tsproject.tms.model.driver;


import ru.tsystems.tsproject.tms.model.dao.DriverDAO;
import ru.tsystems.tsproject.tms.model.entity.Driver;
import ru.tsystems.tsproject.tms.model.entity.Wagon;

import java.util.List;

/**
 * Created by Lena on 05.10.2014.
 */
public class DriverService {
    void getCurOrderInfo(String licenseNumber){
        //необходимо получить водителя по указанному личному номеру licenseNumber
        //Driver driver = new Driver();
        //driver.
        Driver driver;
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.beginTransaction();
        driver = driverDAO.findOnLicenseNumber(licenseNumber);
        driverDAO.commitTransaction();
        if(driver == null)
            return; //нет водителя с такими правами

        //Wagon wagon = driver.getWagon();
        List<Wagon> wagon = driver.getWagon();


    }

    public void changeStatusOfDelivery(){

    }

    public boolean changeStatusOfDriver(long driverId, String status){
        Driver driver = new Driver();
        DriverDAO driverDAO = new DriverDAO();
        driverDAO.beginTransaction();
        driver = driverDAO.getDriver(driverId);
        //driverDAO.commitTransaction();

        if(driver == null)
            //нет такого водителя!
            return false;

        if(driver.getStatus() == status)
            //статусы совпадают
            return false;

        //Wagon wagon = driver.getWagon();
        List<Wagon> wagon = driver.getWagon();

        if(wagon.get(0).getOrder() == null)
            //не можем сменить статус. не вылоняет ни одни заказ
            return false;
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
