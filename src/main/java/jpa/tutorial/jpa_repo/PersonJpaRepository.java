package jpa.tutorial.jpa_repo;

import jpa.tutorial.jdbc.PersonJDBC;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<PersonJpa> findAll() {
        TypedQuery<PersonJpa> namedQuery = entityManager.createNamedQuery("find_all_persons", PersonJpa.class);
        return namedQuery.getResultList();
    }
    public PersonJpa findById(Integer id){
        return entityManager.find(PersonJpa.class,id);
    }
    public PersonJpa update(PersonJpa person){
        return entityManager.merge(person);
    }
    public PersonJpa insert(PersonJpa person){
        return entityManager.merge(person);
    }
    public void deleteById(int id) {
        PersonJpa person = findById(id);
        entityManager.remove(person);
    }
    public void deleteById(PersonJpa person) {
        entityManager.remove(person);
    }

}
