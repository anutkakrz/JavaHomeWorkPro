package org.example.testCollectionT1_T2;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private String lastName;
    private int age;
    private List<Course> studentInCourses;
    @Setter
    private Group group;

    public void setName(String name) {
        if (name != null ) {
            this.name = name;
        } else System.out.println("the name field cannot be null");
    }

    public void setLastName(String lastName) {
        if (lastName!=null) {
        this.lastName = lastName;}
        else System.out.println("the lastName field cannot be null");
    }

    public void setAge(int age) {
        if (age>0) {
        this.age = age;}
        else System.out.println("the age field cannot be 0 oder minus");
    }

    public void setStudentInCourses(List<Course> studentInCourses) {
        if (studentInCourses!=null) {
        this.studentInCourses = studentInCourses;}
        else System.out.println("the studentInCourses field cannot be null");
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addCourse(Course course) {
        studentInCourses.add(course);
    }

    public void deleteCourse(Course course) {
        studentInCourses.remove(course);
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getStudentInCourses() {
        return studentInCourses;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", studentInCourses=" + studentInCourses.size() +
                ", group=" + group.getTitleGroup()+
                '}';
    }
}



