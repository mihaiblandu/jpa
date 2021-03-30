package jpa.tutorial.jpa_repo.repo;

import jpa.tutorial.jpa_repo.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    private EntityManager entityManager;

    public List<Course> findAll(){
        TypedQuery<Course> namedQuery = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        return namedQuery.getResultList();
    }

    public Course findById(Integer id){
        return entityManager.find(Course.class,id);
    }
    public Course save(Course course){
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }
    public void deleteById(Integer id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
    public Course update(Course course) {
       return entityManager.merge(course);
    }
}
