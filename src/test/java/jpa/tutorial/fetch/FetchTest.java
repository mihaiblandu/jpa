package jpa.tutorial.fetch;


import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import jpa.tutorial.dao.OrganisationRepo;
import jpa.tutorial.dao.StudentRepo;
import jpa.tutorial.entities.Organisation;
import jpa.tutorial.entities.Person;
import jpa.tutorial.entities.Student;
import jpa.tutorial.entities.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class FetchTest {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private OrganisationRepo organisationRepo;
    @Test
    public void FetchUser(){
        Assertions.assertEquals(3,studentRepo.findAll().stream().count());
    }

    @Test
    public void FetchUserEager(){

        Locale locale;
        Faker faker = new Faker(Locale.getDefault());
        List<Organisation> list = IntStream.range(1,100).mapToObj(i->{
            Organisation organisation = new Organisation();
            organisation.setId(i);
            organisation.setName(faker.company().name());
            organisation.setPeople(IntStream.range(1,100).mapToObj(j->{
                Person person = new Person();
                person.setId(j);
                person.setName(faker.name().fullName());
                //person.setOrganisation(organisation);
                return person;
            }).collect(Collectors.toList()));
            return organisation;
        }).collect(Collectors.toList());

        organisationRepo.saveAll(list);
        Assertions.assertEquals("same","same");
    }
}
