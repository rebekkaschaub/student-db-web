package de.neuefische.studentwebdb.service;

import de.neuefische.studentwebdb.model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    StudentService studentService = new StudentService(List.of(
            new Student("Hanna","12"),
            new Student("Linda","34"),
            new Student("Theresa","56"),
            new Student("Natalia","78"),
            new Student("Sophie","90"),
            new Student("Sonja","91"),
            new Student("Sascha","94")
    )
    );

    @Test
    void listShouldReturnALLStudents() {
        //WHEN
        List<Student> list = studentService.list();

        //THEN
        assertThat(list, containsInAnyOrder(new Student("Hanna","12"),
                new Student("Linda","34"),
                new Student("Theresa","56"),
                new Student("Natalia","78"),
                new Student("Sophie","90"),
                new Student("Sonja","91"),
                new Student("Sascha","94")));
    }


    @Test
    void findByIdShouldReturnStudentWithMatchingID() {
        //GIVEN
        String idToFind = "78";
        //WHEN
        Optional<Student> actual = studentService.findById(idToFind);
        //THEN
        assertThat(actual.isPresent(), is(true));
        assertThat(actual.get(),is(new Student("Natalia","78")));
    }

    @Test
    void findByIdShouldReturnOptinalEmpty() {
        //GIVEN
        String idToFind = "70";
        //WHEN
        Optional<Student> actual = studentService.findById(idToFind);
        //THEN
        assertThat(actual.isEmpty(), is(true));
        assertThat(actual,is(Optional.empty()));
    }

    @Test
    public void findStudentByNameShouldReturnStudentWithNameContainingSearchString(){
        //GIVEN
        String searchString = "sasch";

        //WHEN
        List<Student> students = studentService.filterStudentsByName(searchString);

        //THEN
        assertThat(students, containsInAnyOrder( new Student("Sascha","94")));
    }


    @Test
    public void findStudentByNameShouldReturnStudentWithNameContainingSearchStringIgnoreCase(){
        //GIVEN
        String searchString = "na";

        //WHEN
        List<Student> students = studentService.filterStudentsByName(searchString);

        //THEN
        assertThat(students, containsInAnyOrder( new Student("Natalia", "78"),
                                                 new Student("Hanna","12")));
    }


}