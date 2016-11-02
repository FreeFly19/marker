package marker.persistence.dao;

import marker.core.dao.StudentDao;
import marker.core.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by FreeFly on 02.11.2016.
 */
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
}
