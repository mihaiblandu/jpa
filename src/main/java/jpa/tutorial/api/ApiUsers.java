package jpa.tutorial.api;


import com.github.javafaker.Faker;
import jpa.tutorial.entities.*;
import jpa.tutorial.repo.MealRepo;
import jpa.tutorial.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
public class ApiUsers {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = userRepository.findAll();
        System.out.println(list.get(0).getName().getFirstName());
        return new ResponseEntity( list, HttpStatus.OK);
    }
    @GetMapping("/add")
    public ResponseEntity addUser(){
        Faker faker = new Faker(Locale.getDefault());
        Name name = new Name(faker.name().firstName(), faker.name().nameWithMiddle(), faker.name().lastName());
        Address address = new Address(faker.address().secondaryAddress(), faker.address().secondaryAddress(), faker.address().city(), "----", faker.company().name(), faker.address().zipCode());
        User user = new User(name, faker.internet().emailAddress(), address);

        userRepository.save(user);
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
}
