package lk.ijse.DG.repository;

import org.hibernate.Session;

public interface SuperRepository {
    public void setSession(Session session)throws Exception;
}
