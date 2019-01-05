package lk.ijse.DG.repository;

import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CrudRepoistoryImpl<T , ID extends Serializable> implements CrudRepository<T, ID> {

    protected Session session;
    private Class<T> type;

    public CrudRepoistoryImpl(){
        type=(Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public boolean save(T entity) throws Exception {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(T entity) throws Exception {
        session.update(entity);
        return true;
    }

    @Override
    public boolean delete(T entity) throws Exception {
        session.delete(entity);
        return true;
    }

    @Override
    public T search(ID id) throws Exception {
        return session.get(type, id);
    }

    @Override
    public List<T> getAllTList() throws Exception {
        System.out.println("crud");
        return session.createQuery("FROM "+type.getName()).list();
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }
}
