package jpa.tutorial.dao;

import jpa.tutorial.entities.University;
import jpa.tutorial.entities.UniversityLazy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityLazyRepo extends JpaRepository<UniversityLazy,Integer> {
}
