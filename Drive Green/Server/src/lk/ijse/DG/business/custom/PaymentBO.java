package lk.ijse.DG.business.custom;

import lk.ijse.DG.business.SuperBO;
import lk.ijse.DG.dto.PaymentDTO;

import java.util.ArrayList;
import java.util.List;

public interface PaymentBO extends SuperBO {
    public boolean savePayment(PaymentDTO paymentDTO) throws Exception;

    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception;

    public boolean deletePayment(PaymentDTO paymentDTO) throws Exception;

    public PaymentDTO searchPayment(String name) throws Exception;

    public List<PaymentDTO> getAllPayments() throws Exception;

    public ArrayList<String> getAllCategory() throws Exception;

    public PaymentDTO searchPaymentCategory(String number)throws Exception;

}
