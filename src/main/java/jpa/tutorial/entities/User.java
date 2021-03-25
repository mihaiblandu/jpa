package jpa.tutorial.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
    private Name name;

    @NotNull
    @Column(unique = true)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;

    public User() {

    }

    public User(Name name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

}