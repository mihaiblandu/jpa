package jpa.tutorial.jpa_repo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Table(name ="person_tutorial")
@NamedQuery(name="find_all_persons", query="select p from PersonJpa p")
public class PersonJpa {
    @Id
    private Integer id;

    private String name;
    private String location;
    private LocalDateTime birth_data;

    public PersonJpa() {

    }
}
