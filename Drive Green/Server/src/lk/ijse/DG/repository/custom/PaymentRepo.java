package lk.ijse.DG.repository.custom;

import lk.ijse.DG.entity.Payment;
import lk.ijse.DG.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment, String> {
    public Payment searchbyCategory(String category)throws Exception;
}
