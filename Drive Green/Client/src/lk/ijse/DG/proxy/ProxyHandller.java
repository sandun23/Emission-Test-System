package lk.ijse.DG.proxy;

import lk.ijse.DG.service.*;

import java.rmi.Naming;

public class ProxyHandller implements ServiceFactory {

    private static ProxyHandller proxyHandller;
    private ReceptionService receptionService;
    private VehicleService vehicleService;
    private PaymentService paymentService;
    private TestService testService;
    private TesterService testerService;

    public static  ProxyHandller getInstance()throws  Exception{
        if(proxyHandller==null){
            proxyHandller = new ProxyHandller();
        }
        return proxyHandller;
    }

    public ProxyHandller()throws Exception{
        ServiceFactory serviceFactory =(ServiceFactory) Naming.lookup("rmi://localhost:5050/drive");
        receptionService = serviceFactory.getSuperService(ServiceTypes.RECEPTIONN);
        vehicleService = serviceFactory.getSuperService(ServiceTypes.VEHICLE);
        paymentService = serviceFactory.getSuperService(ServiceTypes.PAYMENT);
        testerService = serviceFactory.getSuperService(ServiceTypes.TESTER);
        testService = serviceFactory.getSuperService(ServiceTypes.TEST);



    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case TEST:
                return (T) testService;
            case PAYMENT:
                return  (T) paymentService;
            case TESTER:
                return (T)testerService;
            case VEHICLE:
                return (T) vehicleService;
            case RECEPTIONN:
                return (T) receptionService;
                default:
                    return null;
        }
    }
}
