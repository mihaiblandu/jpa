package jpa.tutorial.dao;

import jpa.tutorial.entities.EntityA;
import jpa.tutorial.entities.EntityB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntityBRepo extends JpaRepository<EntityB,Integer> {
    @Query("select c from EntityB c where  c.refEntityA.myIdA = :id")
    List<EntityB> findAllByRefEntityA(Integer id);
}
