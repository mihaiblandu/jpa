package jpa.tutorial.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students;

}
