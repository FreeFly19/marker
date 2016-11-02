package marker.core.entity;

import com.fasterxml.jackson.annotation.JsonView;
import marker.core.util.json.view.StudentView;
import marker.core.util.json.view.VisitView;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by FreeFly on 03.11.2016.
 */
@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = {StudentView.WithVisits.class,VisitView.Minimal.class})
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonView(value = {VisitView.Minimal.class})
    private Student student;

    @JsonView(value = {StudentView.WithVisits.class,VisitView.Minimal.class})
    private LocalDate date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
