package lk.ijse.DG.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    private String pid;
    private String category;
    private double price;

    @OneToMany(mappedBy = "payment",cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    List<Test> test = new ArrayList<>();

    public Payment() {
    }

    public Payment(String pid, String category, double price) {
        this.pid = pid;
        this.category = category;
        this.price = price;
    }

    public Payment(String pid, String category, double price, List<Test> test) {
        this.pid = pid;
        this.category = category;
        this.price = price;
        this.test = test;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }
}
