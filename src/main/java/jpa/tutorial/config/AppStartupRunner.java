package jpa.tutorial.config;

import com.github.javafaker.Faker;
import jpa.tutorial.dao.StudentRepo;
import jpa.tutorial.dao.UniversityLazyRepo;
import jpa.tutorial.dao.UniversityRepo;
import jpa.tutorial.entities.Student;
import jpa.tutorial.entities.University;
import jpa.tutorial.entities.UniversityLazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private UniversityLazyRepo universityLazyRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());
        Faker faker = new Faker();
        Student joe = new Student();
        joe.setName(faker.name().fullName());
        Student john = new Student();
        john.setName(faker.name().fullName());
        Student christy = new Student();
        christy.setName(faker.name().fullName());
        List<Student> list = List.of(joe,john,christy);
        studentRepo.saveAll(list);

        University un = new University();
        un.setAddress(faker.address().fullAddress());
        un.setName(faker.company().name());
        un.setStudents(list);
        UniversityLazy unLazy = new UniversityLazy();
        unLazy.setAddress(faker.address().fullAddress());
        unLazy.setName(faker.company().name());
        unLazy.setStudents(list);
        universityRepo.save(un);
        universityLazyRepo.save(unLazy);
    }
}