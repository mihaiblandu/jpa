package jpa.tutorial.api;


import jpa.tutorial.dao.UniversityLazyRepo;
import jpa.tutorial.dao.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/lazy")
    public ResponseEntity getLazy(){
        return new ResponseEntity(universityLazyRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/eager")
    public ResponseEntity getEager(){
        return new ResponseEntity(universityRepo.findAll(),HttpStatus.OK);
    }
}
