package jpa.tutorial.fetch;


import jpa.tutorial.jpa_repo.Course;
import jpa.tutorial.jpa_repo.CourseRepository;
import jpa.tutorial.jpa_repo.PersonJpa;
import jpa.tutorial.jpa_repo.PersonJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;

@SpringBootTest
public class CoursesCases {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(value = 2)
    public void FetchAll(){
        Assertions.assertEquals(3,courseRepository.findAll().stream().count());
    }
    @Test
    @Order(value = 1)
    public void FetchOne(){
        Assertions.assertEquals("java",courseRepository.findById(1).getName());
    }
    @Test
    @Order(value = 3)
    public void UpdateOne(){

        Course course = new Course(3,"go",LocalDateTime.now(),LocalDateTime.now());
        courseRepository.update(course);
        System.out.println();
       Assertions.assertEquals("go",courseRepository.findById(3).getName());
    }
    @Test
    @Order(value = 4)
    public void InsertOne(){
        Course course = new Course(5,"one",LocalDateTime.now(),LocalDateTime.now());
        courseRepository.save(course);

        Assertions.assertEquals("one",courseRepository.findById(5).getName());
    }
    @Test
    @Order(value = 4)
    public void DeleteOne(){

        courseRepository.deleteById(2);
        Assertions.assertEquals(3,courseRepository.findAll().size());
    }
}
