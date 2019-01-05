package lk.ijse.DG.business.custom;

import lk.ijse.DG.business.SuperBO;
import lk.ijse.DG.dto.TesterDTO;

import java.util.List;

public interface TesterBO extends SuperBO {

    public boolean saveTester(TesterDTO testerDTO)throws Exception;
    public boolean updateTester(TesterDTO testerDTO)throws Exception;
    public boolean deleteTester(TesterDTO testerDTO)throws Exception;
    public TesterDTO searchTester(String name)throws Exception;
    public List<TesterDTO> getAllTesters()throws Exception;
}
