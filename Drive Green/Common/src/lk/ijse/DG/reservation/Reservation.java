package lk.ijse.DG.reservation;

import java.rmi.Remote;

public interface Reservation extends Remote {
    public boolean reserved(Object id)throws Exception;
    public boolean released(Object id)throws Exception;
}
