package jpa.tutorial.entities;


import jpa.tutorial.validation.NotEmpty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String zipCode;


    public Address() {

    }

    public Address(String addressLine1, String addressLine2, String city, 
                   String state, String country, String zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    // Getters and Setters (Omitted for brevity)
}