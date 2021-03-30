package jpa.tutorial.jpa_repo.entities;

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
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
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
