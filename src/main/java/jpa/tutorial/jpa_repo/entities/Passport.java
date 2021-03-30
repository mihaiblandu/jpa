package jpa.tutorial.jpa_repo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch= FetchType.LAZY, mappedBy="passport")
    @JsonIgnore
    private StudentB student;

    protected Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }
}
