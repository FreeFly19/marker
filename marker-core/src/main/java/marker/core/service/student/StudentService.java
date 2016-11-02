package marker.core.service.student;

import marker.core.entity.Student;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
public interface StudentService {
    Student getById(Integer id);
    List<Student> findAll();
}
