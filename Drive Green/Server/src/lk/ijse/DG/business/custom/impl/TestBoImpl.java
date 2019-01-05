package lk.ijse.DG.business.custom.impl;

import lk.ijse.DG.business.custom.TestBO;
import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.entity.*;
import lk.ijse.DG.repository.RepositoryFactory;
import lk.ijse.DG.repository.custom.TestRepo;
import lk.ijse.DG.repository.custom.TesterRepo;
import lk.ijse.DG.resources.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class TestBoImpl implements TestBO {
    TestRepo testRepo = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepoTypes.TEST);

    @Override
    public boolean saveTest(TestDTO testDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            testRepo.setSession(session);
            session.getTransaction().begin();
            Payment payment = session.get(Payment.class, testDTO.getPid());
            Tester tester = session.get(Tester.class, testDTO.getTesterid());
            Vehicle vehicle = session.get(Vehicle.class, testDTO.getVid());
            Reception reception = session.get(Reception.class, "1");
            boolean respo = testRepo.save(new Test(
                    testDTO.getTid(),
                    testDTO.getCenter(),
                    testDTO.getTestFee(),
                    testDTO.getCoStandard(),
                    testDTO.getCoIdel(),
                    testDTO.getCoRpm(),
                    testDTO.getCoTemp(),
                    testDTO.getoStandard(),
                    testDTO.getoIdel(),
                    testDTO.getoRpm(),
                    testDTO.getoTemp(),
                    testDTO.getStatus(),
                    vehicle,
                    reception,
                    tester,
                    payment
            ));
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTest(TestDTO testDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTest(TestDTO testDTO) throws Exception {
        return false;
    }

    @Override
    public TestDTO searchTest(String name) throws Exception {
        return null;
    }

    @Override
    public List<TestDTO> getAllTests() throws Exception {
        return null;
    }
}
