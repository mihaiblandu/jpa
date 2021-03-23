package jpa.tutorial.entities;

import lombok.Data;

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
    private List<Student> students;

}
