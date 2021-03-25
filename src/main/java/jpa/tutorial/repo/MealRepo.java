package jpa.tutorial.repo;

import jpa.tutorial.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepo extends JpaRepository<Meal,Integer> {
}
