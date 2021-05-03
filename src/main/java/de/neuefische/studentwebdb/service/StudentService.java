package de.neuefische.studentwebdb.service;

import de.neuefische.studentwebdb.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

   private final List<Student> students= List.of(
            new Student("Hanna","12"),
            new Student("Linda","34"),
            new Student("Theresa","56"),
            new Student("Natalia","78"),
            new Student("Sophie","90"),
            new Student("Sonja","91"),
            new Student("Sascha","94")

    );


   public List<Student> list(Optional<String> q){
       if(q.isEmpty()){
           return students;
       }else{
           return filterStudentsByFirstLetter(q.get());
       }
   }

    private List<Student> filterStudentsByFirstLetter(String q) {
        List<Student> studentsFiltered = new ArrayList<>();
        for (Student student : students) {
            if(student.getName().startsWith(q)){
                 studentsFiltered.add(student);
            }
        }
        return studentsFiltered;
    }

    public Optional<Student> findById(String id){
       for (Student student : students) {
           if(student.getId().equals(id)){
               return Optional.of(student);
           }
       }
       return Optional.empty();
   }
}
