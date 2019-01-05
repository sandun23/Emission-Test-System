package lk.ijse.DG.repository.custom.impl;

import lk.ijse.DG.entity.Payment;
import lk.ijse.DG.repository.CrudRepoistoryImpl;
import lk.ijse.DG.repository.custom.PaymentRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class PaymentRepoImpl extends CrudRepoistoryImpl<Payment, String> implements PaymentRepo {


    @Override
    public Payment searchbyCategory(String category) throws Exception {
        Payment payment = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from paymet where category =:payment");
        query.setString("payment",category);
        payment=(Payment) query.uniqueResult();
        session.getTransaction().commit();
            return payment;
    }
}
