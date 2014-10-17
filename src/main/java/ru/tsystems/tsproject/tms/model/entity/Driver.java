package ru.tsystems.tsproject.tms.model.entity;
import javax.persistence.*;

/**
 * Created by Lena on 04.10.2014.
 */

@Entity
@Table(name="driver")
public class Driver {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "wagon")
    private Wagon wagon;

    public Driver(){

    }

    public void setId(long id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public void setLicenseNumber(String licenseNumber1){
        this.licenseNumber = licenseNumber;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setWagon(Wagon wagon){
        this.wagon = wagon;
    }

    public long getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }
    public String getStatus(){
        return status;
    }
    public Wagon getWagon(){
        return wagon;
    }

}
