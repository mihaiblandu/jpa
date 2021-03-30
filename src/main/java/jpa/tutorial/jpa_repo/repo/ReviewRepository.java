package jpa.tutorial.jpa_repo.repo;

import jpa.tutorial.jpa_repo.entities.Review;
import jpa.tutorial.jpa_repo.entities.StudentB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ReviewRepository {
    @Autowired
    private EntityManager entityManager;

    public List<Review> findAll(){
        TypedQuery<Review> namedQuery = entityManager.createNamedQuery("query_get_all_reviews", Review.class);
        return namedQuery.getResultList();
    }

    public Review findById(Integer id){
        return entityManager.find(Review.class,id);
    }
    public Review save(Review review){
        if (review.getId() == null) {
            entityManager.persist(review);
        } else {
            entityManager.merge(review);
        }
        return review;
    }
    public void deleteById(Integer id) {
        Review review = findById(id);
        entityManager.remove(review);
    }
    public Review update(Review review) {
       return entityManager.merge(review);
    }
}
