package lk.ijse.DG.business.custom.impl;

import lk.ijse.DG.business.custom.VehicleBO;
import lk.ijse.DG.dto.VehicleDTO;
import lk.ijse.DG.entity.Vehicle;
import lk.ijse.DG.repository.RepositoryFactory;
import lk.ijse.DG.repository.custom.VehicleRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class VehicleBoImpl implements VehicleBO {
    VehicleRepo vehicleRepo = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepoTypes.VEHICLE);

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        vehicleRepo.setSession(session);
        session.getTransaction().begin();
        boolean repo = vehicleRepo.save(new Vehicle(
                vehicleDTO.getVid(),
                vehicleDTO.getChassisNo(),
                vehicleDTO.getEngineNo(),
                vehicleDTO.getFuelType(),
                vehicleDTO.getMake(),
                vehicleDTO.getModel(),
                vehicleDTO.getOwnerName(),
                vehicleDTO.getVehicleClass(),
                vehicleDTO.getVehicleRegNo(),
                vehicleDTO.getYear()));

        session.getTransaction().commit();
        session.close();
        return repo;
    }

    @Override
    public VehicleDTO searchVehicle(String name) throws Exception {
        return null;
    }

    @Override
    public List<VehicleDTO> getAllVehicle() throws Exception {
        List<VehicleDTO> vehicles = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        vehicleRepo.setSession(session);
        session.getTransaction().begin();
        List<Vehicle> allList = vehicleRepo.getAllTList();
        for (Vehicle e : allList){
            vehicles.add(new VehicleDTO(e.getVid(),e.getOwnerName(),e.getVehicleRegNo(),e.getModel()));
        }
        session.getTransaction().commit();
        return vehicles;
    }
}
