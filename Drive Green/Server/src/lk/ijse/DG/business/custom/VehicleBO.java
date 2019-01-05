package lk.ijse.DG.business.custom;

import lk.ijse.DG.business.SuperBO;
import lk.ijse.DG.dto.VehicleDTO;

import java.util.List;

public interface VehicleBO extends SuperBO {
    public boolean addVehicle(VehicleDTO vehicleDTO)throws Exception;
    public VehicleDTO searchVehicle(String name)throws Exception;
    public List<VehicleDTO> getAllVehicle()throws Exception;


}
