package ru.tsystems.tsproject.tms.model.entity;
/**
 * Created by Anton on 04.10.2014.
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="wagon")
@NamedQuery(name = "Wagon.getAll", query = "SELECT c from Wagon c")
public class Wagon extends Entities {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "number_of_driver")
    private int numberOfDriver;

    @Column(name = "class_capacity")
    private String classCapacity;

    /*@OneToOne
    @JoinColumn(name = "order_unique_number")
    private Order order;*/
    @OneToMany(mappedBy = "wagon")
    private List<Order> order;

    @ManyToMany (mappedBy = "wagon")//посмотреть на эту фигню
    //@JoinColumn(name = "driver")
    private List<Driver> drivers;

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
    public void setOrderNumber(List<Order> order){
        this.order = order;
    }
    public void setListOfDrivers(List<Driver> drivers){
        this.drivers = drivers;
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
    public List<Order> getOrder(){
        return order;
    }
    public List<Driver> getListOfDrivers(){
        return drivers;
    }
}
