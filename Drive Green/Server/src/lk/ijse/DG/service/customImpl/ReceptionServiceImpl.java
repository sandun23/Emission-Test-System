package lk.ijse.DG.service.customImpl;

import lk.ijse.DG.business.BusinessFactory;
import lk.ijse.DG.business.custom.ReceptionBO;
import lk.ijse.DG.dto.ReceptionDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.repository.custom.ReceptionRepo;
import lk.ijse.DG.service.ReceptionService;
import lk.ijse.DG.service.TesterService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {
    ReceptionBO receptionBO= BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.RECEPTION);
    public ReceptionServiceImpl() throws RemoteException {
    }

    @Override
    public boolean saveReception(ReceptionDTO receptionDTO) throws Exception {
        return receptionBO.saveReception(receptionDTO);
    }

    @Override
    public boolean updateReception(ReceptionDTO receptionDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteReception(ReceptionDTO receptionDTO) throws Exception {
        return false;
    }

    @Override
    public ReceptionDTO searchReception(String name) throws Exception {
        return null;
    }

    @Override
    public List<ReceptionDTO> getAllReceptions() throws Exception {
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
