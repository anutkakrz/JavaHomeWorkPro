package org.example.testCollectionT1_T3;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {



    public static List<Student> getStudentsInCourse( List<Course> courseList, String titleCourse) {
        List<Student> studentsInCourse = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getTitleCourse().equals(titleCourse)) {
                studentsInCourse.addAll( course.getStudentsInCourse());
            }
        }
        return studentsInCourse;
    }

    public static List<String> getStudentCourses(List<Course> courseList, String lastName){
        List<String> titleCorsesStudent = new ArrayList<>();
        for (Course course: courseList ) {
            for (Student student : course.getStudentsInCourse()){
                if (student.getLastName().equals(lastName)){
                    titleCorsesStudent.add(course.getTitleCourse());
                    break;
                }
            }

        }
        return titleCorsesStudent;
    }

    public static int getNumbersStudentsInCourse (List<Course> courseList, Course course) {
        int numbersStudents = 0;
        for (Course course1 : courseList) {
            if (course.getTitleCourse().equals(course1.getTitleCourse())
                    && !course1.getStudentsInCourse().isEmpty()) {
                numbersStudents = course1.getStudentsInCourse().size();
            }
        }
        return numbersStudents;
    }

    public static int getNumbersStudentsInAllCourses (List<Course> courseList) {
        int numbersStudents = 0;
        for (Course course : courseList) {
            if (  !course.getStudentsInCourse().isEmpty()) {
                numbersStudents += course.getStudentsInCourse().size();
            }
        }
        return numbersStudents;
    }
    public static double getAverageAgeStudents ( List<Student> students) {
        double sumAge =0;
        double numStudents = 0;
        for (Student student : students){
            sumAge += student.getAge();
            numStudents++;
        }
        return sumAge/numStudents;
    }
    public static int getMinAgeStudent ( List<Student> students) {
        int minAge = 999999999;
        for (Student student : students){
          if (student.getAge()<minAge){
              minAge=student.getAge();
          }
        }
        return minAge;
    }
    public static Student getStudentWithMinAge ( List<Student> students) {
        int minAge = 999999999;
        Student studentMinAge = new Student();
        for (Student student : students){
            if (student.getAge()<minAge){
                minAge=student.getAge();
                studentMinAge = student;
            }
        }
        return studentMinAge;
    }
    public static Student getStudentWithMaxAge ( List<Student> students) {
        int maxAge = 0;
        Student studentMaxAge = new Student();
        for (Student student : students){
            if (student.getAge()>maxAge){
                maxAge=student.getAge();
                studentMaxAge = student;
            }
        }
        return studentMaxAge;
    }
    public static Student getStudentWithMaxCourses ( List<Student> students) {
        int maxCourse = 0;
        Student studentWithMaxCourses = new Student();
        for (Student student : students){
            if (student.getStudentInCourses().size()>maxCourse){
                maxCourse=student.getStudentInCourses().size();
                studentWithMaxCourses= student;
            }
        }
        return studentWithMaxCourses;
    }
    public static Student getStudentWithMinCourses ( List<Student> students) {
        int minCourse = 99999999;
        Student studentWithMinCourses = new Student();
        for (Student student : students){
            if (student.getStudentInCourses().size()<minCourse){
                minCourse=student.getStudentInCourses().size();
                studentWithMinCourses= student;
            }
        }
        return studentWithMinCourses;
    }
    public static double getAverageCoursesStudent ( List<Student> students) {
        double sumCourses =0;
        double numStudents = 0;
        for (Student student : students){
            sumCourses += student.getStudentInCourses().size();
            numStudents++;
        }
        return sumCourses/numStudents;
    }
}
