package marker.core.service.student;

import marker.core.dao.StudentDao;
import marker.core.entity.Student;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer id) {
        return studentDao.getByPK(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
