package lk.ijse.DG.business.custom.impl;

import lk.ijse.DG.business.custom.ReceptionBO;
import lk.ijse.DG.dto.ReceptionDTO;
import lk.ijse.DG.entity.Reception;
import lk.ijse.DG.repository.RepositoryFactory;
import lk.ijse.DG.repository.custom.ReceptionRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ReceptionBoImpl implements ReceptionBO {

    ReceptionRepo receptionRepo = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepoTypes.RECEPTION);

    @Override
    public boolean saveReception(ReceptionDTO receptionDTO) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        receptionRepo.setSession(session);
        session.getTransaction().begin();
        boolean save = receptionRepo.save(new Reception(
                receptionDTO.getRid(),
                receptionDTO.getName(),
                receptionDTO.getAddress(),
                receptionDTO.getTele()
        ));
        session.getTransaction().commit();
        session.close();

        return save;
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
}
