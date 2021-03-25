package jpa.tutorial.dao;

import jpa.tutorial.entities.EntityA;
import jpa.tutorial.entities.Organisation;
import jpa.tutorial.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntityARepo extends JpaRepository<EntityA,Integer> {

}
