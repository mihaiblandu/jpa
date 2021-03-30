package jpa.tutorial.jpa_repo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",
                query = "Select  c  From Course c")
})
public class Course {
    @Id
    private Integer id;

    @Column(nullable = false,length = 200)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastupdated;
    @CreationTimestamp
    private LocalDateTime createddate;
    @OneToMany(mappedBy="course")
    @JsonIgnoreProperties("course")
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany(mappedBy="courses")
    @JsonIgnore
    private List<StudentB> students = new ArrayList<>();
    public Course() {
    }
}
