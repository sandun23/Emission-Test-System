package lk.ijse.DG.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Test {

    @Id
    private String tid;
    private String center;
    private double testFee;
    private int coStandard;
    private int coIdel;
    private int coRpm;
    private int coTemp;

    private int oStandard;
    private int oIdel;
    private int oRpm;
    private int oTemp;

    private String status;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Vehicle vehicle;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Reception reception;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Tester tester;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Payment payment;

    public Test() {
    }

    public Test(String tid, String center, double testFee, int coStandard, int coIdel, int coRpm, int coTemp, int oStandard, int oIdel, int oRpm, int oTemp, String status, Vehicle vehicle, Reception reception, Tester tester, Payment payment) {
        this.tid = tid;
        this.center = center;
        this.testFee = testFee;
        this.coStandard = coStandard;
        this.coIdel = coIdel;
        this.coRpm = coRpm;
        this.coTemp = coTemp;
        this.oStandard = oStandard;
        this.oIdel = oIdel;
        this.oRpm = oRpm;
        this.oTemp = oTemp;
        this.status = status;
        this.vehicle = vehicle;
        this.reception = reception;
        this.tester = tester;
        this.payment = payment;
    }


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public double getTestFee() {
        return testFee;
    }

    public void setTestFee(double testFee) {
        this.testFee = testFee;
    }

    public int getCoStandard() {
        return coStandard;
    }

    public void setCoStandard(int coStandard) {
        this.coStandard = coStandard;
    }

    public int getCoIdel() {
        return coIdel;
    }

    public void setCoIdel(int coIdel) {
        this.coIdel = coIdel;
    }

    public int getCoRpm() {
        return coRpm;
    }

    public void setCoRpm(int coRpm) {
        this.coRpm = coRpm;
    }

    public int getCoTemp() {
        return coTemp;
    }

    public void setCoTemp(int coTemp) {
        this.coTemp = coTemp;
    }

    public int getoStandard() {
        return oStandard;
    }

    public void setoStandard(int oStandard) {
        this.oStandard = oStandard;
    }

    public int getoIdel() {
        return oIdel;
    }

    public void setoIdel(int oIdel) {
        this.oIdel = oIdel;
    }

    public int getoRpm() {
        return oRpm;
    }

    public void setoRpm(int oRpm) {
        this.oRpm = oRpm;
    }

    public int getoTemp() {
        return oTemp;
    }

    public void setoTemp(int oTemp) {
        this.oTemp = oTemp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
