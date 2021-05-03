package de.neuefische.studentwebdb.controller;

import de.neuefische.studentwebdb.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public List<Student> listStudents(){
        return List.of(
                new Student("Hanna","89"),
                new Student("Linda","89"),
                new Student("Theresa","89"),
                new Student("Natalia","89"),
                new Student("Sophie","89")
        );
    }
}
