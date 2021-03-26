package jpa.tutorial.dao;

import jdk.dynalink.linker.LinkerServices;
import jpa.tutorial.entities.Organisation;
import jpa.tutorial.entities.Person;
import jpa.tutorial.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    List<Person> findAllByOrganisation(Organisation id);
    Page<Person> findAllByNameLike(String like, Pageable page);
}
