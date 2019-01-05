package lk.ijse.DG.service;


import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.observer.Subject;
import lk.ijse.DG.reservation.Reservation;

import java.util.List;

public interface TestService extends SuperService, Reservation, Subject {
    public boolean saveTest(TestDTO testDTO)throws Exception;
    public boolean updateTest(TestDTO testDTO)throws Exception;
    public boolean deleteTest(TestDTO testDTO)throws Exception;
    public TestDTO searchTest(String name)throws Exception;
    public List<TestDTO> getAllTests()throws Exception;


}
