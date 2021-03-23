package jpa.tutorial.dao;

import jpa.tutorial.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University,Integer> {
}
