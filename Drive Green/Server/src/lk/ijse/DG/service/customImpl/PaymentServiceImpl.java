package lk.ijse.DG.service.customImpl;

import lk.ijse.DG.business.BusinessFactory;
import lk.ijse.DG.business.custom.PaymentBO;
import lk.ijse.DG.dto.PaymentDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.service.PaymentService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl extends UnicastRemoteObject implements PaymentService {

    PaymentBO paymentBO = BusinessFactory.getInstance().getBusiness(BusinessFactory.BusinessTypes.PAYMENT);

    public PaymentServiceImpl() throws RemoteException {
    }

    @Override
    public boolean savePayment(PaymentDTO paymentDTO) throws Exception {
            return paymentBO.savePayment(paymentDTO);
    }

    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        return paymentBO.updatePayment(paymentDTO);
    }

    @Override
    public boolean deletePayment(PaymentDTO paymentDTO) throws Exception {
        return false;
    }

    @Override
    public PaymentDTO searchPayment(String name) throws Exception {
        return null;
    }

    @Override
    public List<PaymentDTO> getAllPayments() throws Exception {
        return paymentBO.getAllPayments();
    }

    @Override
    public ArrayList<String> getAllCategory() throws Exception {
        return paymentBO.getAllCategory();

    }

    @Override
    public PaymentDTO searchbyCategory(String category) throws Exception {
        return paymentBO.searchPayment(category);
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
