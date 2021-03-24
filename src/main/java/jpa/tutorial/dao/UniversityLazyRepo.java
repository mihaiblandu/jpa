package jpa.tutorial.dao;

import jpa.tutorial.entities.University;
import jpa.tutorial.entities.UniversityLazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Queue;

public interface UniversityLazyRepo extends JpaRepository<UniversityLazy,Integer> {

}
