package jpa.tutorial.api;


import jpa.tutorial.dao.*;
import jpa.tutorial.entities.Organisation;
import jpa.tutorial.repo.BankRepo;
import jpa.tutorial.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private UniversityLazyRepo universityLazyRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private EntityBRepo entityBRepo;
    @GetMapping("/lazy")
    public ResponseEntity getLazy(){
        return new ResponseEntity(universityLazyRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/eager")
    public ResponseEntity getEager(){
        return new ResponseEntity(universityRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity getA(@PathVariable Integer id){
        Organisation org = new Organisation();
        org.setId(Integer.valueOf(1));
        return new ResponseEntity(personRepo.findAllByOrganisation(org),HttpStatus.OK);
    }

    @GetMapping("/pages/{pageNumber}")
    public ResponseEntity getOther(@PathVariable Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber, 30, Sort.by("name").ascending());
        Organisation org = new Organisation();
        org.setId(Integer.valueOf("1"));
        return new ResponseEntity(personRepo.findAll(page),HttpStatus.OK);
    }

    @GetMapping("/pageslike/{pageNumber}")
    public ResponseEntity getLike(@PathVariable Integer pageNumber,@RequestParam("like") String like){
        Pageable page = PageRequest.of(pageNumber, 30, Sort.by("name").ascending());
        Organisation org = new Organisation();
        org.setId(Integer.valueOf("1"));
        return new ResponseEntity(personRepo.findAllByNameLike(like+"%",page),HttpStatus.OK);
    }

    @GetMapping("/banks")
    public ResponseEntity getBanks(){
        return new ResponseEntity(bankRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/customers")
    public ResponseEntity getCustomer(){
        return new ResponseEntity(customerRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/customersByBank/{id}")
    public ResponseEntity getCustomerBank(@PathVariable("id") Integer id){
        return new ResponseEntity(customerRepo.findAllByBank(id),HttpStatus.OK);
    }

    @GetMapping("/refB/{id}")
    public ResponseEntity getRefB(@PathVariable("id") Integer id){
        return new ResponseEntity(entityBRepo.findAllByRefEntityA(id),HttpStatus.OK);
    }

}
