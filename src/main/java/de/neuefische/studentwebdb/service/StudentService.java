package de.neuefische.studentwebdb.service;

import de.neuefische.studentwebdb.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

   private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> list(){
           return students;
   }

   public List<Student> filterStudentsByName(String search) {
        List<Student> studentsFiltered = new ArrayList<>();
        for (Student student : students) {
            if(student.getName().toLowerCase().contains(search.toLowerCase())){
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

   public void addStudent(Student student){
        students.add(student);
   }

   public void removeStudent(String id){

        if(findById(id).isPresent()) {
            students.remove(findById(id).get());
        }
   }


    public void updateStudent(Student student) {
        removeStudent(student.getId());
        addStudent(student);
    }
}
