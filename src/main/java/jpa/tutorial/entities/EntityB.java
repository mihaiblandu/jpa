package jpa.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EntityB {
  @Id
  @GeneratedValue
  private int myIdB;
  private String strB;
  @ManyToOne
  @JsonIgnore
  @JoinTable(name = "MY_JOIN_TABLE",
          joinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", insertable = false,
                  updatable = false, referencedColumnName = "myIdB")},
          inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", insertable = false,
                  updatable = false, referencedColumnName = "myIdA")}
  )
  private EntityA refEntityA;
}