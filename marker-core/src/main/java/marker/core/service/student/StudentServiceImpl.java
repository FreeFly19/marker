package marker.core.service.student;

import marker.core.dao.StudentDao;
import marker.core.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
//    @Cacheable(value = "students")
    public Student getById(Integer id) {
        return studentDao.getByPK(id);
    }

    @Override
    //@Cacheable(value = "students")
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    //@CacheEvict(value = "students")
    public void modify() {}
}
