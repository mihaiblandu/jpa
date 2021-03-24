package jpa.tutorial.api;


import jpa.tutorial.dao.PersonRepo;
import jpa.tutorial.dao.StudentRepo;
import jpa.tutorial.dao.UniversityLazyRepo;
import jpa.tutorial.dao.UniversityRepo;
import jpa.tutorial.entities.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private UniversityRepo universityRepo;
    @Autowired
    private UniversityLazyRepo universityLazyRepo;
    @Autowired
    private PersonRepo personRepo;
    @GetMapping("/lazy")
    public ResponseEntity getLazy(){
        return new ResponseEntity(universityLazyRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/eager")
    public ResponseEntity getEager(){
        return new ResponseEntity(universityRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity getOther(){
        Pageable page = PageRequest.of(0, 100);
        Organisation org = new Organisation();
        org.setId(Integer.valueOf("1"));
        return new ResponseEntity(personRepo.findAllByOrganisation(org),HttpStatus.OK);
    }
}
