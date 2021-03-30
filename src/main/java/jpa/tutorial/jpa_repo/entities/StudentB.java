package jpa.tutorial.jpa_repo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_students",
                query = "Select  s  From StudentB s")
})
@ToString
public class StudentB {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Passport passport;


    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    protected StudentB() {
    }

    public StudentB(String name) {
        this.name = name;
    }

    @UpdateTimestamp
    private LocalDateTime lastupdated;
    @CreationTimestamp
    private LocalDateTime createddate;
}
