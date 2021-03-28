package jpa.tutorial.jdbc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class PersonJDBC {
    @Id
    private Integer id;

    private String name;
    private String location;
    private LocalDateTime birth_data;

    public PersonJDBC() {

    }
}
