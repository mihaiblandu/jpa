package jpa.tutorial;

import jpa.tutorial.dao.UniversityLazyRepo;
import jpa.tutorial.dao.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    public ResponseEntity get(){
        return new ResponseEntity("{}",HttpStatus.OK);
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
