package lk.ijse.DG.service;

import lk.ijse.DG.dto.VehicleDTO;
import lk.ijse.DG.observer.Subject;
import lk.ijse.DG.reservation.Reservation;
import lk.ijse.DG.service.SuperService;

import java.util.List;

public  interface VehicleService extends SuperService, Reservation, Subject {
    public boolean addVehicle(VehicleDTO vehicleDTO)throws Exception;
    public VehicleDTO searchVehicle(String name)throws Exception;
    public  List<VehicleDTO>  getAllVehicle()throws Exception;



}
