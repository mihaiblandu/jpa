package jpa.tutorial.api;

import jpa.tutorial.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class ApiPerson {
    @Autowired
    private PersonJdbcDao personJdbcDao;
    @GetMapping("all")
    public ResponseEntity getAll(){
        return new ResponseEntity(personJdbcDao.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return new ResponseEntity(personJdbcDao.findById(id),HttpStatus.OK);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        return new ResponseEntity(personJdbcDao.deleteById(id),HttpStatus.OK);
    }
}
