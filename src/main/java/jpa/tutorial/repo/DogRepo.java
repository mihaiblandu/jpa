package jpa.tutorial.repo;

import jpa.tutorial.entities.Customer;
import jpa.tutorial.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepo extends JpaRepository<Dog,Integer> {
}
