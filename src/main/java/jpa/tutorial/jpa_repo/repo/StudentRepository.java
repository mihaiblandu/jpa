package jpa.tutorial.jpa_repo.repo;

import jpa.tutorial.jpa_repo.entities.Course;
import jpa.tutorial.jpa_repo.entities.StudentB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    private EntityManager entityManager;

    public List<StudentB> findAll(){
        TypedQuery<StudentB> namedQuery = entityManager.createNamedQuery("query_get_all_students", StudentB.class);
        return namedQuery.getResultList();
    }

    public StudentB findById(Integer id){
        return entityManager.find(StudentB.class,id);
    }
    public StudentB save(StudentB student){
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return student;
    }
    public void deleteById(Integer id) {
        StudentB student = findById(id);
        entityManager.remove(student);
    }
    public StudentB update(StudentB student) {
       return entityManager.merge(student);
    }
}
