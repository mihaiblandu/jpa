package jpa.tutorial.config;

import com.github.javafaker.Faker;
import jpa.tutorial.dao.*;
import jpa.tutorial.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private UniversityLazyRepo universityLazyRepo;
    @Autowired
    private OrganisationRepo organisationRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private EntityARepo entityARepo;
    @Autowired
    private EntityBRepo entityBRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());
        Faker faker = new Faker(Locale.getDefault());

/*        List students = IntStream.range(1,100000).mapToObj(i-> {

            Student stu = new Student();
            stu.setId(i);
            stu.setName(faker.name().fullName());

            return stu;
        }).collect(Collectors.toList());
        studentRepo.saveAll(students);

        University un = new University();
        un.setAddress(faker.address().fullAddress());
        un.setName(faker.company().name());
        un.setStudents(students);
        UniversityLazy unLazy = new UniversityLazy();
        unLazy.setAddress(faker.address().fullAddress());
        unLazy.setName(faker.company().name());
        unLazy.setStudents(students);
        universityRepo.save(un);
        universityLazyRepo.save(unLazy);*/
        List<Organisation> list = IntStream.range(1,100).mapToObj(i->{
            Organisation organisation = new Organisation();
            //organisation.setId(i);
            organisation.setName(faker.company().name());
            organisation.setAddress(faker.address().fullAddress());
            organisationRepo.save(organisation);
            organisation.setPeople(IntStream.range(1,100).mapToObj(j->{
                Person person = new Person();
                //person.setId(j);
                person.setName(faker.name().fullName());
                person.setOrganisation(organisation);
                //personRepo.save(person);
                return person;
            }).collect(Collectors.toList()));
            return organisation;
        }).collect(Collectors.toList());

        organisationRepo.saveAll(list);
        List<EntityA> listA = IntStream.range(1,100).mapToObj(i->{
            EntityA entityA = new EntityA();
            entityA.setStrA(faker.space().company());
            List<EntityB> listB =IntStream.range(1,10).mapToObj(j->{
                EntityB entityB = new EntityB();
                entityB.setStrB(faker.company().name());
                return entityB;
            }).collect(Collectors.toList());
            entityBRepo.saveAll(listB);
            entityA.setEntityBList(listB);
            return entityA;
        }).collect(Collectors.toList());
        entityARepo.saveAll(listA);
    }
}