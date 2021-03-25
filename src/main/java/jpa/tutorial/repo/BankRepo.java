package jpa.tutorial.repo;

import jpa.tutorial.entities.Bank;
import jpa.tutorial.entities.EntityA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Integer> {
}
