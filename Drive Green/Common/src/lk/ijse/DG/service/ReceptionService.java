package lk.ijse.DG.service;

import lk.ijse.DG.dto.ReceptionDTO;
import lk.ijse.DG.observer.Subject;
import lk.ijse.DG.reservation.Reservation;
import lk.ijse.DG.service.SuperService;

import java.util.List;

public interface ReceptionService extends SuperService, Reservation, Subject {
    public boolean saveReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean deleteReception(ReceptionDTO receptionDTO)throws Exception;
    public ReceptionDTO searchReception(String name)throws Exception;
    public List<ReceptionDTO> getAllReceptions()throws Exception;
}
