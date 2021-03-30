package jpa.tutorial.fetch;


import jpa.tutorial.jpa_repo.entities.Course;
import jpa.tutorial.jpa_repo.entities.Review;
import jpa.tutorial.jpa_repo.repo.CourseRepository;
import jpa.tutorial.jpa_repo.repo.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;

@SpringBootTest
public class ReviewCases {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private EntityManager entityManager;
    @Test
    public void FetchAll(){
        Assertions.assertEquals(9,reviewRepository.findAll().stream().count());
    }
    @Test
    public void FetchOne(){
        Assertions.assertTrue(reviewRepository.findById(1) != null);
    }

}
