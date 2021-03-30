package jpa.tutorial.api;

import jpa.tutorial.jpa_repo.repo.CourseRepository;
import jpa.tutorial.jpa_repo.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class ApiCourse {
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("all")
    public ResponseEntity getAll(){
        return new ResponseEntity(courseRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return new ResponseEntity(courseRepository.findById(id),HttpStatus.OK);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        courseRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
