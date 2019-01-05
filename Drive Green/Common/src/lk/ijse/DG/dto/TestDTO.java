package lk.ijse.DG.dto;

public class TestDTO extends  SuperDTO {

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

    private String vid;
    private String rid;
    private String testerid;
    private String pid;
    private String status;

    public TestDTO(String tid, String center, int coIdel, int coRpm, int coStandard, int coTemp, int oIdel, int oRpm, int oStandard, int oTemp, String status, double fee, String paymentID, String testerID, String vid) {
        this.tid = tid;
        this.center = center;
        this.testFee = fee;
        this.coStandard = coStandard;
        this.coIdel = coIdel;
        this.coRpm = coRpm;
        this.coTemp = coTemp;
        this.oStandard = oStandard;
        this.oIdel = oIdel;
        this.oRpm = oRpm;
        this.oTemp = oTemp;
        this.vid = vid;
        this.testerid = testerID;
        this.pid = paymentID;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "tid='" + tid + '\'' +
                ", center='" + center + '\'' +
                ", testFee=" + testFee +
                ", coStandard=" + coStandard +
                ", coIdel=" + coIdel +
                ", coRpm=" + coRpm +
                ", coTemp=" + coTemp +
                ", oStandard=" + oStandard +
                ", oIdel=" + oIdel +
                ", oRpm=" + oRpm +
                ", oTemp=" + oTemp +
                ", vid='" + vid + '\'' +
                ", rid='" + rid + '\'' +
                ", testerid='" + testerid + '\'' +
                ", pid='" + pid + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTesterid() {
        return testerid;
    }

    public void setTesterid(String testerid) {
        this.testerid = testerid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
