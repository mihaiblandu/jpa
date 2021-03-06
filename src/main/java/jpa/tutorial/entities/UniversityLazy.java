package jpa.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UniversityLazy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    @BatchSize(size=16)
    private List<Student> students;

}
