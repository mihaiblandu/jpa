package jpa.tutorial.fetch;


import jpa.tutorial.jpa_repo.entities.PersonJpa;
import jpa.tutorial.jpa_repo.repo.PersonJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.core.annotation.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class JpaCases {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Test
    @Order(value = 2)
    public void FetchAll(){
        Assertions.assertEquals(11,personJpaRepository.findAll().stream().count());
    }
    @Test
    @Order(value = 1)
    public void FetchOne(){
        Assertions.assertEquals("mihai blandu",personJpaRepository.findById(2).getName());
    }
    @Test
    @Order(value = 3)
    public void UpdateOne(){

       PersonJpa john = new PersonJpa(1,"John","France", LocalDateTime.now().minusYears(29));

       personJpaRepository.update(john);
        System.out.println();
       Assertions.assertEquals("John",personJpaRepository.findById(1).getName());
    }
    @Test
    @Order(value = 4)
    public void InsertOne(){

        PersonJpa joe = new PersonJpa();
        joe.setId(12);
        joe.setName("harry potter");
        joe.setLocation("imaginarium");
        joe.setBirth_data(LocalDateTime.now().minusYears(28));

        personJpaRepository.insert(joe);
        Assertions.assertEquals(12,personJpaRepository.findAll().size());
    }
    @Test
    @Order(value = 4)
    public void DeleteOne(){

        personJpaRepository.deleteById(9);
        Assertions.assertEquals(11,personJpaRepository.findAll().size());
    }
}
