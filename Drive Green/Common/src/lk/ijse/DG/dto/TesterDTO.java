package lk.ijse.DG.dto;

public class TesterDTO extends SuperDTO {
    private String rid;
    private String name;
    private String address;
    private String tele;

    @Override
    public String toString() {
        return "TesterDTO{" +
                "rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }

    public TesterDTO(String rid, String name, String address, String tele) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.tele = tele;
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

    public TesterDTO() {
    }
}
