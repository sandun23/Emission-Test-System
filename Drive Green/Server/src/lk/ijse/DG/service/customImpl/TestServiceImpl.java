package lk.ijse.DG.service.customImpl;

import lk.ijse.DG.business.BusinessFactory;
import lk.ijse.DG.business.custom.TestBO;
import lk.ijse.DG.business.custom.TesterBO;
import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.reservation.ReservationImpl;
import lk.ijse.DG.service.TestService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl  extends UnicastRemoteObject implements TestService {
    TestBO testBO = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.TEST);
    private static ArrayList<Observer> allTestsObserver = new ArrayList <>();
    public static ReservationImpl<TestService> testServiceReservation  = new ReservationImpl <>();

    public TestServiceImpl() throws RemoteException {
    }

    @Override
    public boolean saveTest(TestDTO testDTO) throws Exception {
        notifyAllObserver(testDTO.getTid()+" "+"Test Has Complete");
        return testBO.saveTest(testDTO);
    }

    @Override
    public boolean updateTest(TestDTO testDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTest(TestDTO testDTO) throws Exception {
        return false;
    }

    @Override
    public TestDTO searchTest(String name) throws Exception {
        return null;
    }

    @Override
    public List<TestDTO> getAllTests() throws Exception {
        return null;
    }

    @Override
    public void register(Observer observer) throws Exception {
            allTestsObserver.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allTestsObserver.remove(observer);
    }

    @Override
    public void notifyAllObserver(String message) throws Exception {
        for (Observer observer : allTestsObserver){
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