package jpa.tutorial.dao;

import jpa.tutorial.entities.EntityA;
import jpa.tutorial.entities.EntityB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityBRepo extends JpaRepository<EntityB,Integer> {
}
