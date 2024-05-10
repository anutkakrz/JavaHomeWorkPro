package org.example.testCollectionT3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person person4 = new Person("Andrey","Petrov",25);
        Person person1 = new Person("Tonya","Petrova",25);
        Person person2 = new Person("Sonya","Egorova",25);
        Person person3 = new Person("Misha","Zhadniy",25);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        List<Student> students = new ArrayList<>();
        Student student3 = new Student("Misha","Zhadniy",25,102,true);
        Student student1 = new Student("Sonya","Egorova",25,111,true);
        Student student2 = new Student("Misha","Zhadniy",25,64,false);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Person[] people = new Person[]{person1,person2,person3,person4,student1,student2,student3};
        Teacher teacher1 = new Teacher("Elena","Les",25,"Java","VSOP",true);
        Teacher teacher2 = new Teacher("Olena","Ogon",25,"Java","VIP",false);
        Teacher teacher3 = new Teacher("Mikhail","Voda",25,"English","VS",true);
        Person[] people1 = new Person[]{student1,student2,student3,teacher1,teacher2,teacher3};



        System.out.println(persons);
        System.out.println(students);
        System.out.println(student1.getIdentity());
        for (Person person: people){
            System.out.println(person.describe());
        }
        System.out.println(student3.getCommunityStatus());
        System.out.println(student3.getIdentity());
        System.out.println(Teacher.getTeachersThisSubject(people1,"Java"));

        for (Person person : people1){
            System.out.println(person);
        }
    }
}
