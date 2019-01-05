package lk.ijse.DG.service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceTypes{
        VEHICLE,TEST,TESTER,RECEPTIONN,PAYMENT;
    }

    public <T>T getSuperService(ServiceTypes serviceTypes)throws Exception;

}
