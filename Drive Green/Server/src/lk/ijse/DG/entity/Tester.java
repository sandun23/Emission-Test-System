package lk.ijse.DG.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tester {

    @Id
    private String rid;
    private String name;
    private String address;
    private String tele;

    @OneToMany(mappedBy = "tester",cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    List<Test> test = new ArrayList<>();

    public Tester(String rid, String name, String address, String tele) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.tele = tele;
    }

    public Tester() {
    }

    public Tester(String rid, String name, String address, String tele, List<Test> test) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.tele = tele;
        this.test = test;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }
}
