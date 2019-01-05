package lk.ijse.DG.service;

import lk.ijse.DG.dto.PaymentDTO;
import lk.ijse.DG.observer.Subject;
import lk.ijse.DG.reservation.Reservation;
import lk.ijse.DG.service.SuperService;

import java.util.ArrayList;
import java.util.List;

public interface PaymentService extends SuperService, Reservation, Subject {
    public boolean savePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean updatePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean deletePayment(PaymentDTO paymentDTO)throws Exception;
    public PaymentDTO searchPayment(String name)throws Exception;
    public List<PaymentDTO> getAllPayments()throws Exception;

    public ArrayList<String> getAllCategory()throws Exception;


    public PaymentDTO searchbyCategory(String category)throws Exception;

}
