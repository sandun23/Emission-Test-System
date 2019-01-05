package lk.ijse.DG.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    private String vid;
    private String vehicleRegNo;
    private String ownerName;
    private String chassisNo;
    private String engineNo;
    private String vehicleClass;
    private String make;
    private String model;
    private String fuelType;
    private String year;
    @OneToMany(mappedBy = "vehicle",cascade = {CascadeType.PERSIST})
    List<Test> test = new ArrayList <>();

    public Vehicle(String vid, String vehicleRegNo, String ownerName, String chassisNo, String engineNo, String vehicleClass, String make, String model, String fuelType, String year) {
        this.vid = vid;
        this.vehicleRegNo = vehicleRegNo;
        this.ownerName = ownerName;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.vehicleClass = vehicleClass;
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
    }

    public Vehicle() {
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    public Vehicle(String vid, String vehicleRegNo, String ownerName, String chassisNo, String engineNo, String vehicleClass, String make, String model, String fuelType, String year, List<Test> test) {
        this.vid = vid;
        this.vehicleRegNo = vehicleRegNo;
        this.ownerName = ownerName;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.vehicleClass = vehicleClass;
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
        this.test = test;
    }
}
