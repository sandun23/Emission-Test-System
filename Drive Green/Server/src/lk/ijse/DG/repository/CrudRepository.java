package lk.ijse.DG.repository;

import java.util.List;

public interface CrudRepository<T , ID> extends SuperRepository {
    public boolean save(T entity)throws Exception;
    public boolean update(T entity)throws Exception;
    public boolean delete(T entity)throws Exception;
    public T search(ID id)throws Exception;
    public List<T> getAllTList()throws Exception;
}
