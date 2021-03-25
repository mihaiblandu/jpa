package jpa.tutorial.api;


import com.github.javafaker.Faker;
import jpa.tutorial.entities.Allergens;
import jpa.tutorial.entities.Dog;
import jpa.tutorial.entities.Meal;
import jpa.tutorial.repo.DogRepo;
import jpa.tutorial.repo.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

@RestController
public class ApiDogs {
    @Autowired
    private MealRepo mealRepo;

    @GetMapping("/all")
    public ResponseEntity getDogs(){
        return new ResponseEntity(mealRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/add")
    public ResponseEntity putDogs(){
        Faker faker = new Faker(Locale.getDefault());

        Meal meal = new Meal();
        Allergens allergens = new Allergens();
        allergens.setCelery(true);
        allergens.setPeanuts(true);
        allergens.setSesameSeeds(true);
        meal.setAllergens(allergens);
        meal.setDescription("Description");
        meal.setName("Name of  meal");

        meal.setPrice(BigDecimal.valueOf(100));
        mealRepo.save(meal);
        return new ResponseEntity(mealRepo.findAll(), HttpStatus.OK);
    }
}
