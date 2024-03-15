package com.swiftlearn.leaningproject.controllers;

import com.swiftlearn.leaningproject.entity.Student;
import com.swiftlearn.leaningproject.entity.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;
//  this is constructor injection it functions the same as when you use annotation @Autowired
//   but this is much recommended than use @Autowired annotation
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

//    in this methode when ever this path requested it will attempt to save the student
    @PostMapping("/student/save")
    public void saveStudent(){
        Student student = new Student();
        student.setEmail("benard.agustin@gmail.com");
        student.setGrade("Grade 2");
        student.setPhone("078946736");
        student.setName("Benard Agustin");

        repository.save(student);

    }

//    this methode is a little bit same as the above one but this request Student object when
//    the request sent to the endpoint
//    NB: post request can have @RequestBody because it can receive body to save in Database
    @PostMapping("/student/save-request")
    public  Student saveStudentFromRequest(@RequestBody Student student){
       return repository.save(student);
    }


//    when ever the /student/find requested the data the methode tends to find in an entity Student
//    a student with certain email.... the request maybe like localhost:8080/students/find-email?email=benard.agustin@gmail.com
    @GetMapping("/students/find-email")
    public  Student findByEmail(@RequestParam("email") String email){

        return repository.findByEmail(email);
    }

//  PatchMapping used to patch the present data like update when the endpoint /student/update requested should pass values
//  first one is id used to search student by id and the second one is email used to update the present email
    @PatchMapping("/student/update")
    public Student upDateStudent(@RequestParam("id") long id, @RequestParam("new_email") String email){
//   the Option type used tho escape the null point error because the student with given id may not exist
      Optional<Student> student = repository.findById(id);
      if(student.isPresent()){
          Student studentObj = student.get();
          studentObj.setEmail(email);
          return repository.save(studentObj);
      }
      return  null;
    }

//  The method use get request once the below endpoint is requested, and it's going to find all students with particular domain
    @GetMapping("/students/find-by-domain")
    public List<Student> findByEmailDomain(@RequestParam("domain") String domain){
        return repository.findByDomain(domain);
    }

}
