package jpa.tutorial.fetch;


import jpa.tutorial.jpa_repo.entities.Course;
import jpa.tutorial.jpa_repo.repo.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;

@SpringBootTest
public class CoursesCases {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;
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

        Course course = new Course(3,"go",LocalDateTime.now(),LocalDateTime.now(),null,null);
        courseRepository.update(course);
        System.out.println();
       Assertions.assertEquals("go",courseRepository.findById(3).getName());
    }
    @Test
    @Order(value = 4)
    public void InsertOne(){
        Course course = new Course(6,"one",LocalDateTime.now(),LocalDateTime.now(),null,null);
        courseRepository.save(course);

        Assertions.assertEquals("one",courseRepository.findById(6).getName());
    }
    @Test
    @Order(value = 4)
    public void DeleteOne(){

        courseRepository.deleteById(2);
        Assertions.assertFalse(courseRepository.findById(2) != null);
    }

    @Test
    @Order(value = 4)
    public void Native(){
        Query queue = entityManager.createNativeQuery("select * from course",Course.class);

        Assertions.assertTrue(2 <= queue.getResultList().size());
    }

}
