package jpa.tutorial.repo;

import jpa.tutorial.entities.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatasetRepo extends JpaRepository<Dataset,Integer> {
}
