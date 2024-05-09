package org.example.testCollectionT1_T3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Student ivanov = new Student("Igor", "Ivanov", 22, new ArrayList<>(),new Group());
        Student ivanova = new Student("Eva", "Ivanova", 31, new ArrayList<>(),new Group());
        Student svetlaya = new Student("Svetlana", "Svetlaya", 19, new ArrayList<>(),new Group());
        Student petrov = new Student("Serg", "Petrov", 25, new ArrayList<>(),new Group());
        Student lutiy = new Student("Andrey", "Lutiy", 26, new ArrayList<>(),new Group());
        Student lutiy1 = new Student("Egor", "Lutiy", 19, new ArrayList<>(),new Group());
        Student polet = new Student("Katya", "Polet", 31, new ArrayList<>(),new Group());


        List<Student> students = new ArrayList<>();
        students.add(ivanov);
        students.add(ivanova);
        students.add(svetlaya);
        students.add(petrov);
        students.add(lutiy);
        students.add(polet);
        students.add(lutiy1);


        List<Student> studentsJava = new ArrayList<>();
        studentsJava.add(ivanov);
        studentsJava.add(svetlaya);
        studentsJava.add(lutiy);
        studentsJava.add(lutiy1);

        List<Student> studentsPython = new ArrayList<>();
        studentsPython.add(ivanova);
        studentsPython.add(polet);
        studentsPython.add(svetlaya);
        studentsPython.add(petrov);

        List<Student> studentscPlusPlus = new ArrayList<>();
        studentscPlusPlus.add(ivanova);
        studentscPlusPlus.add(lutiy1);

        List<Student> studentsenglish = new ArrayList<>();
        studentsenglish.add(ivanova);
        studentsenglish.add(petrov);
        studentsenglish.add(polet);
        studentsenglish.add(lutiy);

        System.out.println("\nСтуденты: " + students + " \n");

        List<Course> courseList = new ArrayList<>();
        Course java = new Course("Java", studentsJava);
        Course python = new Course("Python", studentsPython);
        Course cPlusPlus = new Course("C++", studentscPlusPlus);
        Course english = new Course("English", studentsenglish);

        courseList.add(java);
        courseList.add(python);
        courseList.add(cPlusPlus);
        courseList.add(english);

        List<Student> studentMorningGroup = new ArrayList<>();
        List<Student> studentEveningGroup = new ArrayList<>();

        studentMorningGroup.add(ivanova);
        studentMorningGroup.add(petrov);
        studentMorningGroup.add(lutiy1);
        studentMorningGroup.add(svetlaya);
        studentEveningGroup.add(ivanov);
        studentEveningGroup.add(lutiy);
        studentEveningGroup.add(polet);

        Group morningGroup = new Group("MorningGroup", studentMorningGroup);
        Group eveningGroup = new Group("EveningGroup", studentEveningGroup);
        List<Group> groups = new ArrayList<>();
        groups.add(morningGroup);
        groups.add(eveningGroup);

        for (Student student : students) {
            for (Course course : courseList) {
                if (course.getStudentsInCourse().contains(student)) {
                    student.addCourse(course);
                }
            }
        }

        for (Student student : students){
            for (Group group : groups) {
                if (group.getStudentsInGroupe().contains(student)) {
                    student.setGroup(group);
                }
            }
        }

        System.out.println("\nКурсы: ");
        for (Course course : courseList) {
            System.out.println(course.getTitleCourse());
        }
        System.out.println("\nСтуденты на курсе java: " + (Methods.getStudentsInCourse(courseList, "Java")));
        System.out.println("\nСтуденты: " + students);
        System.out.println(("\nстудент Иванова учится на курсах: " + Methods.getStudentCourses(courseList, "Ivanova")));
        System.out.println(("\nкол-во студентов которые учатся на заданном курсе " + Methods.getNumbersStudentsInCourse(courseList, english)));
        System.out.println(("\nкол-во студентов которые учатся на курсах(c повторами) " + Methods.getNumbersStudentsInAllCourses(courseList)));
        System.out.println(("\nсредний возраст студентов:  " + Methods.getAverageAgeStudents(students)));
        System.out.println(("\nсамый минимальный возраст студента:  " + Methods.getMinAgeStudent(students)));
        System.out.println(("\nсамый молодой студент:  " + Methods.getStudentWithMinAge(students)));
        System.out.println(("\nсамый взрослый студент:  " + Methods.getStudentWithMaxAge(students)));
        System.out.println(("\nстудент который учится на макс кол-ве курсов:  " + Methods.getStudentWithMaxCourses(students)));
        System.out.println(("\nстудент который учится на мин кол-ве курсов:  " + Methods.getStudentWithMinCourses(students)));
        System.out.println(("\nсреднее кол-во курсов на одного студента:  " + Methods.getAverageCoursesStudent(students)));
        Collections.sort(students);
        System.out.println(("\nстуденты отсортированы по возрасту: "+students));
        Collections.sort(students, StudentComparator.nameComparator);
        System.out.println(("\nстуденты отсортированы по имени:"));
        for (Student student : students) {
            System.out.println(student.getName());
        }
        Collections.sort(students,StudentComparator.lastNameComparator);
        System.out.println(("\nстуденты отсортированы по фамилии: "));
        for (Student student : students) {
            System.out.println(student.getLastName());
        }
        Collections.sort(students,StudentComparator.nameComparatorAgeIdentical);
        System.out.println("\nСортировка по возрасту и имени: ");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }
        Collections.sort(students,StudentComparator.multiLevelSort);
        System.out.println("\nСортировка по фамилии затем по имени и возрасту: ");
        for (Student student : students) {
            System.out.println(student.getLastName()+" "+student.getName() + " - " + student.getAge());
        }
        Collections.sort(students, StudentComparator.titleGroupAgeSort);
        System.out.println("\nСортировка по группе а затем по фамилии: ");
        for (Student student : students) {
            System.out.println(student.getGroup()+" "+student.getAge()+" "+student.getLastName());
        }
    }
}
