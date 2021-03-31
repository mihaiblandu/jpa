package jpa.tutorial.jpa_repo.repo;

import jpa.tutorial.jpa_repo.entities.Employee;
import jpa.tutorial.jpa_repo.entities.FullTimeEmployee;
import jpa.tutorial.jpa_repo.entities.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public void save(Employee employee){
        if(employee.getId() == null){
            entityManager.persist(employee);
        }else {
            entityManager.merge(employee);
        }
    }

    public List<PartTimeEmployee> getAllPartTimeEmployeeList(){
        return entityManager.createQuery("select Em from PartTimeEmployee Em").getResultList();
    }
    public List<FullTimeEmployee> getAllFullEmployeeList(){
        return entityManager.createQuery("select Em from FullTimeEmployee Em").getResultList();
    }
}
