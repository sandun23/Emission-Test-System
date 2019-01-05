package lk.ijse.DG.business.custom;

import lk.ijse.DG.business.SuperBO;
import lk.ijse.DG.dto.TestDTO;


import java.util.List;

public interface TestBO extends SuperBO {

    public boolean saveTest(TestDTO testDTO)throws Exception;
    public boolean updateTest(TestDTO testDTO)throws Exception;
    public boolean deleteTest(TestDTO testDTO)throws Exception;
    public TestDTO searchTest(String name)throws Exception;
    public List<TestDTO> getAllTests()throws Exception;


}
