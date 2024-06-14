package org.example.java1006;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.java1006.Major.*;

public class StudentRegistry {
    @Getter
    static Map<Integer, Student> studentMap = new HashMap<>();
    private static final Faker FAKER = new Faker();
    static int id = 0;

    public static void main(String[] args) {

    }

    public static int getId() {
        id++;
        return id;
    }


    public static Student generateStudent() {
        Major[] majors = Major.values();
        return new Student(
                getId(),
                FAKER.name().firstName(),
                FAKER.name().fullName(),
                FAKER.internet().emailAddress(),
                FAKER.number().randomDouble(2, 1, 5),
                majors[FAKER.number().numberBetween(0, majors.length)],
                FAKER.number().numberBetween(1, 6),
                FAKER.bool().bool()
        );

    }

    public static void putStudents() {
        for (int i = 0; i < 20; i++) {
            Student student = generateStudent();
            studentMap.put(student.getId(), student);

        }
    }

    public static void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            throw new IllegalArgumentException("такой студент уже существует");
        }
        studentMap.put(student.getId(), student);
    }

    public static void removeStudent(int id) {
        if (!studentMap.containsKey(id)) {
            throw new NoSuchElementException("такого студента нет");
        }
        studentMap.remove(id);

    }


//    findStudentsByMajor(String major) - возвращает список студентов, обучающихся на указанной специальности.

    public static List<Student> getStudentsInThisMajor(String findMajor){
        List<Student> students = studentMap.values().stream()
                .filter(student -> student.major.equals(findMajor))
                .collect(Collectors.toList());
        return students;
    }


//    calculateAverageGrade() - вычисляет средний балл среди всех студентов.

    public static double getAvarage(){
        if (studentMap.isEmpty()){
            throw new NoSuchElementException("мапа пустая");
        }
       double avarage = studentMap.values().stream()
                .mapToDouble(el -> el.grade)
                .average()
                .getAsDouble();
       return avarage;
    }

//    listStudentsByYear(int year) - возвращает список студентов, обучающихся на указанном курсе.

    public static List<Student> getStudentsInThisKurs(int finfYear){
        List<Student> students = studentMap.values().stream()
                .filter(student -> student.year==finfYear)
                .collect(Collectors.toList());
        return students;
    }

//    getStudent(int id) - возвращает студента по его идентификатору.
//            getTotalNumberOfStudents() - возвращает общее количество студентов.
//    getStudentsWithGradeAbove(double grade) - возвращает список студентов, чей средний балл выше указанного.
//            getAverageGradeByMajor(String major) - вычисляет средний балл среди студентов определенной специальности.
//            isStudentPresent(String email) - проверяет, существует ли студент с заданным email в реестре.
}




