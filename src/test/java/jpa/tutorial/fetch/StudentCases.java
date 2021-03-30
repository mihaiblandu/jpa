package jpa.tutorial.fetch;


import jpa.tutorial.jpa_repo.entities.Address;
import jpa.tutorial.jpa_repo.entities.Course;
import jpa.tutorial.jpa_repo.entities.StudentB;
import jpa.tutorial.jpa_repo.repo.CourseRepository;
import jpa.tutorial.jpa_repo.repo.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Stubber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
public class StudentCases {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;
    @Test
    @Order(value = 2)
    public void FetchAll(){


    }
    @Test
    @Order(value = 1)
    public void FetchOne(){
    }
    @Test
    @Order(value = 3)
    public void UpdateOne(){

        StudentB student = studentRepository.findById(1);

        student.setAddress(new Address("1","2","corj"));
        studentRepository.save(student);
        System.out.println(studentRepository.findById(1).getName());
     }
    @Test
    @Order(value = 4)
    public void InsertOne(){
        studentRepository.save(new StudentB("jimmy"));


        Assertions.assertTrue(1 < studentRepository.findAll().size());
      }
    @Test
    @Order(value = 4)
    public void DeleteOne(){

        studentRepository.deleteById(1);
        Assertions.assertTrue(3 <= studentRepository.findAll().size());
      }

    @Test
    @Order(value = 4)
    public void Native(){
        Query queue = entityManager.createNativeQuery("select * from studentb", StudentB.class);

        Assertions.assertEquals(studentRepository.findAll().size(),queue.getResultList().size());
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        StudentB student = entityManager.find(StudentB.class, 1);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
        Assertions.assertNotNull(student);
    }

}
