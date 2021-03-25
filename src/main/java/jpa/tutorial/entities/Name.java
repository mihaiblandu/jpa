package jpa.tutorial.entities;

import jpa.tutorial.validation.NotEmpty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {
    private String firstName;

    private String middleName;

    private String lastName;

    public Name() {

    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Getters and Setters (Omitted for brevity)
}