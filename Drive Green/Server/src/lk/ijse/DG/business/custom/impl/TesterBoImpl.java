package lk.ijse.DG.business.custom.impl;

import lk.ijse.DG.business.custom.TesterBO;
import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.entity.Tester;
import lk.ijse.DG.repository.RepositoryFactory;
import lk.ijse.DG.repository.custom.TesterRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TesterBoImpl implements TesterBO {
    TesterRepo testerRepo = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepoTypes.TESTER);
    @Override
    public boolean saveTester(TesterDTO testerDTO) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        testerRepo.setSession(session);
        session.getTransaction().begin();
        boolean resp = testerRepo.save(new Tester(
                testerDTO.getRid(),
                testerDTO.getName(),
                testerDTO.getAddress(),
                testerDTO.getTele()
        ));
        session.getTransaction().commit();
        session.close();
        return  resp;
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
}
