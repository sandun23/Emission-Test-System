package lk.ijse.DG.business.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.DG.business.custom.PaymentBO;
import lk.ijse.DG.dto.PaymentDTO;
import lk.ijse.DG.entity.Payment;
import lk.ijse.DG.repository.RepositoryFactory;
import lk.ijse.DG.repository.custom.PaymentRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PaymentBoImpl implements PaymentBO {

    PaymentRepo paymentRepo = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepoTypes.PAYMENT);

    @Override
    public boolean savePayment(PaymentDTO dto) throws Exception {

        Session openSession = HibernateUtil.getSessionFactory().openSession();
        paymentRepo.setSession(openSession);
        openSession.getTransaction().begin();
        boolean response = paymentRepo.save(new Payment(
                dto.getPid(),
                dto.getCategory(),
                dto.getPrice()
        ));

        openSession.getTransaction().commit();
        openSession.close();

        return response;
    }
    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        return false;
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
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            paymentRepo.setSession(session);
            session.getTransaction().begin();
            List<Payment>payments=paymentRepo.getAllTList();
            session.getTransaction().commit();

            if (payments != null){
                List<PaymentDTO>paymentDTOS=new ArrayList<>();
                for (Payment dto:payments){
                    paymentDTOS.add(new PaymentDTO(dto.getPid(),dto.getCategory(),dto.getPrice()));
                }
                return paymentDTOS;
            }else {
                return null;
            }
        }
    }

    @Override
    public ArrayList<String> getAllCategory() throws Exception {
        ArrayList<String> category= new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        paymentRepo.setSession(session);
        session.getTransaction().begin();

        List<Payment> alltlist = paymentRepo.getAllTList();
        for (Payment r : alltlist){
            category.add(r.getCategory());
        }

        session.getTransaction().commit();
        return category;
    }

    @Override
    public PaymentDTO searchPaymentCategory(String number) throws Exception {
        Payment payment =  paymentRepo.searchbyCategory(number);
        if (payment!= null){
           return new PaymentDTO(payment.getPid(),payment.getPrice());
        }
        return null;
    }
}
