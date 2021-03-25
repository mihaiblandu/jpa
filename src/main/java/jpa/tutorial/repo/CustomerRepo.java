package jpa.tutorial.repo;

import jpa.tutorial.entities.Bank;
import jpa.tutorial.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query("select c from Customer c where c.bank.id = :id")
    List<Customer> findAllByBank(Integer id);
}
