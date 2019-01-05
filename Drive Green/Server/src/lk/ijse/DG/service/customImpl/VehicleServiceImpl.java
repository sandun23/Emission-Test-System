package lk.ijse.DG.service.customImpl;

import lk.ijse.DG.business.BusinessFactory;
import lk.ijse.DG.business.custom.VehicleBO;
import lk.ijse.DG.dto.VehicleDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.reservation.ReservationImpl;
import lk.ijse.DG.service.VehicleService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VehicleServiceImpl  extends UnicastRemoteObject implements VehicleService {

    VehicleBO vehicleBO = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.VEHICLE);
    private static ArrayList<Observer> allVehicleObserver = new ArrayList <>();
    public static ReservationImpl<VehicleService> vehicleServiceReservation  = new ReservationImpl <>();


    public VehicleServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception {
        notifyAllObserver(vehicleDTO.getVehicleRegNo()+" "+"Vehicle Is Added");
        return  vehicleBO.addVehicle(vehicleDTO);
    }

    @Override
    public VehicleDTO searchVehicle(String name) throws Exception {
        return null;
    }

    @Override
    public List<VehicleDTO> getAllVehicle() throws Exception {
        return vehicleBO.getAllVehicle();
    }

    @Override
    public void register(Observer observer) throws Exception {
            allVehicleObserver.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
            allVehicleObserver.remove(observer);
    }

    @Override
    public void notifyAllObserver(String message) throws Exception {
        for (Observer observer : allVehicleObserver){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        observer.update(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean released(Object id) throws Exception {
        return false;
    }
}