package jpa.tutorial.jpa_repo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="find_all_courses", query="select p from Course p")
public class Course {
    @Id
    private Integer id;

    @Column(nullable = false,length = 200)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastupdated;
    @CreationTimestamp
    private LocalDateTime createddate;
    public Course() {
    }
}
