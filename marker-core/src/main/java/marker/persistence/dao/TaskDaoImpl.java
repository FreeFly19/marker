package marker.persistence.dao;

import marker.core.dao.TaskDao;
import marker.core.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
@Repository
public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDao {
}
