package lk.ijse.DG.observer;

import java.rmi.Remote;

public interface Subject extends Remote {
    public void register(Observer observer)throws Exception;
    public void unregister(Observer observer)throws Exception;
    public void notifyAllObserver(String message)throws Exception;
}
