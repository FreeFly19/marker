package marker.core.entity;

import com.fasterxml.jackson.annotation.JsonView;
import marker.core.util.json.view.StudentView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by FreeFly on 02.11.2016.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(StudentView.Minimal.class)
    private Integer id;
    private String email;

    @Column(name = "first_name")
    @JsonView(StudentView.Minimal.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(StudentView.Minimal.class)
    private String lastName;

    @Column(name = "phone_number")
    @JsonView(StudentView.Minimal.class)
    private String phoneNumber;

    @OneToMany(mappedBy = "student")
    @JsonView(StudentView.WithVisits.class)
    private Set<Visit> visits = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}

