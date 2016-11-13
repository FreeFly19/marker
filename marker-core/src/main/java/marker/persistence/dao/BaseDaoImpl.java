package marker.persistence.dao;

import marker.core.dao.BaseDao;
import marker.core.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    protected Class<T> entityClass;

    public BaseDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {
        String jpqlSelect = String.format("select entity from %s entity", entityClass.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        return getEntityManager().createQuery(jpqlSelect, entityClass).getResultList();
    }

    @Override
    public T getByPK(Object pk) {
        return getEntityManager().find(entityClass, pk);
    }

    protected EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
