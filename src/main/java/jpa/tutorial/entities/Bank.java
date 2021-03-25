package jpa.tutorial.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    @JoinTable(name = "Bank_Customer",
            joinColumns = {@JoinColumn(name = "Bank_FK", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Customer_FK", referencedColumnName = "ID")}
    )
    private List<Customer> customers;
}
