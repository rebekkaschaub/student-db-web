package de.neuefische.studentwebdb.controller;

import de.neuefische.studentwebdb.model.Student;

import de.neuefische.studentwebdb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService = new StudentService();

    @GetMapping
    public List<Student> listStudents(@RequestParam Optional<String> q){
        return studentService.list(q);
    }

    @GetMapping(path ="{id}")
    public Student getStudent(@PathVariable String id){
        Optional<Student> optionalStudent = studentService.findById(id);
        return optionalStudent.orElse(null);
    }

}
