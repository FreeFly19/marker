package marker.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import marker.core.entity.Student;
import marker.core.service.student.StudentService;
import marker.core.util.json.view.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return studentService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(StudentView.Full.class)
    public Student getById(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

    @GetMapping("/clear")
    public void clear() {
        studentService.modify();
    }

    @GetMapping("/caches")
    public String[] caches() {
        return net.sf.ehcache.CacheManager.create().getCacheNames();
    }
}
