package lk.ijse.DG.dto;

public class PaymentDTO extends SuperDTO {
    private String pid;
    private String category;
    private double price;

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "pid='" + pid + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
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

    public PaymentDTO(String pid, String category, double price) {
        this.pid = pid;
        this.category = category;
        this.price = price;
    }

    public PaymentDTO(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public PaymentDTO() {
    }
}
