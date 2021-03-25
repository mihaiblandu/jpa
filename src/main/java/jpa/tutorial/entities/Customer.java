package jpa.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    @JsonIgnore
    @JoinTable(name = "Bank_Customer",
            joinColumns = {@JoinColumn(name = "Customer_FK", insertable = false,
                    updatable = false, referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Bank_FK", insertable = false,
                    updatable = false, referencedColumnName = "ID")}
    )
    private Bank bank;
}
