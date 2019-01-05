package lk.ijse.DG.service;


import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.observer.Subject;
import lk.ijse.DG.reservation.Reservation;
import lk.ijse.DG.service.SuperService;

import java.util.List;

public interface TesterService extends SuperService, Reservation, Subject {
    public boolean saveTester(TesterDTO testerDTO)throws Exception;
    public boolean updateTester(TesterDTO testerDTO)throws Exception;
    public boolean deleteTester(TesterDTO testerDTO)throws Exception;
    public TesterDTO searchTester(String name)throws Exception;
    public List<TesterDTO> getAllTesters()throws Exception;
}
