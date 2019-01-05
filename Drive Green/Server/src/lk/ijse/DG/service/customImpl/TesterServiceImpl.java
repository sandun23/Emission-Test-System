package lk.ijse.DG.service.customImpl;

import lk.ijse.DG.business.BusinessFactory;
import lk.ijse.DG.business.custom.TesterBO;
import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.service.TesterService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TesterServiceImpl  extends UnicastRemoteObject implements TesterService {

    TesterBO testerBO = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.TESTER);

    public TesterServiceImpl() throws RemoteException {
    }

    @Override
    public boolean saveTester(TesterDTO testerDTO) throws Exception {
        return testerBO.saveTester(testerDTO);
    }

    @Override
    public boolean updateTester(TesterDTO testerDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTester(TesterDTO testerDTO) throws Exception {
        return false;
    }

    @Override
    public TesterDTO searchTester(String name) throws Exception {
        return null;
    }

    @Override
    public List<TesterDTO> getAllTesters() throws Exception {
        return null;
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObserver(String message) throws Exception {

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
