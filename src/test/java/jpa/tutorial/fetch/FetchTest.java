package jpa.tutorial.fetch;


import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import jpa.tutorial.dao.StudentRepo;
import jpa.tutorial.entities.Student;
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
        System.out.println("OK");
        Faker faker = new Faker();
        Student joe = new Student();
        joe.setName(faker.name().fullName());
        Student john = new Student();
        joe.setName(faker.name().fullName());
        Student christy = new Student();
        joe.setName(faker.name().fullName());
        List<Student> list = List.of(joe,john,christy);
        studentRepo.saveAll(list);
        Assertions.assertEquals(list.size(),studentRepo.findAll().stream().count());
    }

    @Test
    public void FetchUserEager(){
        System.out.println("OK");
        Assertions.assertEquals("same","same");
    }
}
