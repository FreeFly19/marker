package marker.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import marker.core.entity.Student;
import marker.core.service.student.StudentService;
import marker.core.util.json.view.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by FreeFly on 03.11.2016.
 */
@RestController
@RequestMapping(value = "/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    @JsonView(StudentView.WithVisits.class)
    public List<Student> getAll() {
        List<Student> all = studentService.findAll();
        return all;
    }
}
