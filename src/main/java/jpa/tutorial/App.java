package jpa.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

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