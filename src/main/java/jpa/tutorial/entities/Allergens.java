package jpa.tutorial.entities;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Allergens {

    @Column(name = "peanuts", table = "allergens")
    boolean peanuts;

    @Column(name = "celery", table = "allergens")
    boolean celery;

    @Column(name = "sesame_seeds", table = "allergens")
    boolean sesameSeeds;

    // standard getters and setters

}