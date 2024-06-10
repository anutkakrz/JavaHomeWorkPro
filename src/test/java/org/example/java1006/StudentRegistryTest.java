package org.example.java1006;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.example.java1006.Major.*;

public class StudentRegistryTest extends TestCase {

@Test
    public void AddStudentTest() {
Student student = StudentRegistry.generateStudent();
StudentRegistry.addStudent(student);
        Assertions.assertTrue(StudentRegistry.getStudentMap().containsKey(student.getId()));
    }
@Test
    public void addStudentWithExeptionTest(){
        Student student = StudentRegistry.generateStudent();
        StudentRegistry.addStudent(student);
        Assertions.assertThrows(IllegalArgumentException.class, ()->StudentRegistry.addStudent(student) );
    }
@Test
    public void removeStudentTest() {
    Student student = StudentRegistry.generateStudent();
    StudentRegistry.addStudent(student);
    StudentRegistry.removeStudent(student.id);
    Assertions.assertFalse(StudentRegistry.studentMap.containsKey(student.id));
    }

    @Test
    public void removeStudentWithExeptionTest() {
        Student student = StudentRegistry.generateStudent();
        StudentRegistry.addStudent(student);
        StudentRegistry.removeStudent(student.id);
        Assertions.assertThrows(NoSuchElementException.class,()->StudentRegistry.removeStudent(student.id));
    }
@Test
    public void getAvarageTest() {
    StudentRegistry.addStudent(new Student(1, "Igor","Lutiy","lkj@lk.com",3.00,MANAGER,2,false));
    StudentRegistry.addStudent(new Student(2, "Igor","Lutiy","lkj@lk.com",4.00,MANAGER,2,false));
    StudentRegistry.addStudent(new Student(3, "Igor","Lutiy","lkj@lk.com",5.00,MANAGER,2,false));
    StudentRegistry.addStudent(new Student(4, "Igor","Lutiy","lkj@lk.com",6.00,MANAGER,2,false));
    StudentRegistry.addStudent(new Student(5, "Igor","Lutiy","lkj@lk.com",2.00,MANAGER,2,false));

    StudentRegistry.getAvarage();
    Assertions.assertEquals(4.00, StudentRegistry.getAvarage());
    }

    @Test
    public void getAvarageWithExeptionTest() {

        Assertions.assertThrows(NoSuchElementException.class,()->StudentRegistry.getAvarage());
    }
@Test
    public void getStudentsInThisMajorTest() {
    StudentRegistry.addStudent(new Student(1, "Igor1","Lutiy","lkj@lk.com",3.00,MANAGER,1,false));
    StudentRegistry.addStudent(new Student(2, "Igor2","Lutiy","lkj@lk.com",4.00,MANAGER,2,false));
    StudentRegistry.addStudent(new Student(3, "Igor3","Lutiy","lkj@lk.com",5.00,ECONOMIST,3,false));
    StudentRegistry.addStudent(new Student(4, "Igor4","Lutiy","lkj@lk.com",6.00,ECONOMIST,4,false));
    StudentRegistry.addStudent(new Student(5, "Igor5","Lutiy","lkj@lk.com",2.00, HISTORIAN,5,false));



}
@Test
    public void getStudentsInThisKursTest() {
    }
}