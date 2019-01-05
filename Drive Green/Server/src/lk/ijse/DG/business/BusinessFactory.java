package lk.ijse.DG.business;


import lk.ijse.DG.business.custom.impl.*;

public class BusinessFactory {
    private static BusinessFactory businessFactory;

    public static BusinessFactory getInstance(){
        if(businessFactory == null){
            businessFactory = new BusinessFactory();
        }
        return businessFactory;
    }

    public enum BusinessTypes{
        VEHICLE,TEST,TESTER,RECEPTION,PAYMENT
    }
    public <T> T getBusiness(BusinessTypes businessTypes){
        switch (businessTypes){
            case VEHICLE:
                return (T) new VehicleBoImpl();
            case TEST:
                return (T) new TestBoImpl();
            case TESTER:
                return (T) new TesterBoImpl();
            case RECEPTION:
                return (T) new ReceptionBoImpl();
            case PAYMENT:
                return (T) new PaymentBoImpl();
            default:
                return null;
        }
    }
}
