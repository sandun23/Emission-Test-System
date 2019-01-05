package lk.ijse.DG.business.custom;

import lk.ijse.DG.business.SuperBO;
import lk.ijse.DG.dto.ReceptionDTO;

import java.util.List;

public interface ReceptionBO extends SuperBO {
    public boolean saveReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;
    public boolean deleteReception(ReceptionDTO receptionDTO)throws Exception;
    public ReceptionDTO searchReception(String name)throws Exception;
    public List<ReceptionDTO> getAllReceptions()throws Exception;
}
