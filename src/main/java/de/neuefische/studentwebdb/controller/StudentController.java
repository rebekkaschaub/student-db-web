package de.neuefische.studentwebdb.controller;

import de.neuefische.studentwebdb.model.Student;

import de.neuefische.studentwebdb.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService = new StudentService(List.of(
            new Student("Hanna","12"),
            new Student("Linda","34"),
            new Student("Theresa","56"),
            new Student("Natalia","78"),
            new Student("Sophie","90"),
            new Student("Sonja","91"),
            new Student("Sascha","94")
    )
    );

    @GetMapping
    public List<Student> listStudents(@RequestParam Optional<String> search){
        if(search.isEmpty()){
            return studentService.list();
        }

        return studentService.filterStudentsByName(search.get());

    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable String id){
        Optional<Student> optionalStudent = studentService.findById(id);
        return optionalStudent.orElse(null);
    }

    @PutMapping("{id}")
    public void addStudent(@Valid @RequestBody Student student,
                           @PathVariable String id){
        if(!id.equals(student.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not matching");
        }
        if(studentService.findById(id).isEmpty()){
            studentService.addStudent(student);
        }else

    }

    @DeleteMapping("{id}")
    public void removeStudentByID(@PathVariable String id){
        studentService.removeStudent(id);
    }

}
