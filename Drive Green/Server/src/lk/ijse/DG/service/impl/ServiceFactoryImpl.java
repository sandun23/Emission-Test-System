package lk.ijse.DG.service.impl;

import lk.ijse.DG.service.ServiceFactory;
import lk.ijse.DG.service.customImpl.*;

import java.rmi.server.UnicastRemoteObject;

public class  ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public ServiceFactoryImpl()throws Exception{

    }
    public static ServiceFactoryImpl serviceFactory;

    public static  ServiceFactoryImpl getInstance()throws Exception{
        if(serviceFactory==null){
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case RECEPTIONN:
                return (T) new ReceptionServiceImpl();
            case VEHICLE:
                return (T) new VehicleServiceImpl();
            case TEST:
                return (T) new TestServiceImpl();
            case TESTER:
                return (T) new TesterServiceImpl();
            case PAYMENT:
                return (T) new PaymentServiceImpl();

            default:
                return null;
        }

    }
}
