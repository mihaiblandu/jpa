package jpa.tutorial.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class EntityA {
  @Id
  @GeneratedValue
  private int myIdA;
  private String strA;
  @OneToMany
  @JoinTable(name = "MY_JOIN_TABLE",
          joinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", referencedColumnName = "myIdA")},
          inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", referencedColumnName = "myIdB")}
  )
  private List<EntityB> entityBList;
}