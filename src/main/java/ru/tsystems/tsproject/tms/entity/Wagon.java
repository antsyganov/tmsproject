package ru.tsystems.tsproject.tms.entity;
/**
 * Created by Lena on 04.10.2014.
 */
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="wagon")
public class Wagon {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "number_of_driver")
    private int numberOfDriver;

    @Column(name = "class_capacity")
    private String classCapacity;

    @OneToOne
    @JoinColumn(name = "order")
    private Order order;

    private ArrayList listOfDrivers;

    public Wagon(){

    }

    public void setId(long id){
        this.id = id;
    }
    public void setRegNumber(String regNumber){
        this.regNumber = regNumber;
    }
    public void setNumberOfDriver(int numberOfDriver){
        this.numberOfDriver = numberOfDriver;
    }
    public void setClassCapacity(String classCapacity){
        this.classCapacity = classCapacity;
    }
    public void setOrderNumber(Order orderNumber){
        this.order = orderNumber;
    }
    public void setListOfDrivers(ArrayList list){
        listOfDrivers = list;
    }

    public long getId(){
        return id;
    }
    public String getRegNumber(){
        return regNumber;
    }
    public int getNumberOfDriver(){
        return numberOfDriver;
    }
    public String getClassCapacity(){
        return classCapacity;
    }
    public Order getOrderNumber(){
        return order;
    }
    public ArrayList getListOfDrivers(){
        return listOfDrivers;
    }
}
