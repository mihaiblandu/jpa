package jpa.tutorial.dao;

import jpa.tutorial.entities.Student;
import jpa.tutorial.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
