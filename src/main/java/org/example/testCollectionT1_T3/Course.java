package org.example.testCollectionT1_T3;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;



class Course {
    private String titleCourse;
    private List<Student> studentsInCourse;

    public Course(String titleCourse, List<Student> studentsInCourse) {
        this.titleCourse = titleCourse;
        this.studentsInCourse = studentsInCourse;
    }

    public void setTitleCourse(String titleCourse) {
        if (titleCourse!=null){
            this.titleCourse = titleCourse;}
        else System.out.println("the titleCourse field cannot be null");
    }

    public void setStudentsInCourse(List<Student> studentsInCourse) {
        if (studentsInCourse!=null){
            this.studentsInCourse = studentsInCourse;}
        else System.out.println("the studentsInCourse field cannot be null");
    }

    public String getTitleCourse() {
        return titleCourse;
    }

    public List<Student> getStudentsInCourse() {
        return studentsInCourse;
    }
}
