package jpa.tutorial.dao;

import jpa.tutorial.entities.Organisation;
import jpa.tutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepo extends JpaRepository<Organisation,Integer> {
}
