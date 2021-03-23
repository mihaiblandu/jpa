package jpa.tutorial.fetch;


import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import jpa.tutorial.dao.StudentRepo;
import jpa.tutorial.entities.Student;
import jpa.tutorial.entities.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@SpringBootTest
public class FetchTest {
    @Autowired
    private StudentRepo studentRepo;
    @Test
    public void FetchUser(){
        Assertions.assertEquals(3,studentRepo.findAll().stream().count());
    }

    @Test
    public void FetchUserEager(){

        Assertions.assertEquals("same","same");
    }
}
