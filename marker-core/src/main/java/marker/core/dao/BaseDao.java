package marker.core.dao;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
public interface BaseDao<T> {
    List<T> findAll();
    T getByPK(Object pk);
}
