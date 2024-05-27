package org.example.testCollectionT3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Teacher extends Person implements CommunityMember{

    private String subject;
    private String categoryTeacher;
    private boolean isActive;

    public Teacher(String name, String lastName, int age, String subject, String categoryTeacher, boolean isActive) {
        super(name, lastName, age);
        this.subject = subject;
        this.categoryTeacher = categoryTeacher;
        this.isActive = isActive;
    }

    public Teacher(String subject, String categoryTeacher, boolean isActive) {
        this.subject = subject;
        this.categoryTeacher = categoryTeacher;
        this.isActive = isActive;
    }

    public static List<Teacher> getTeachersThisSubject (Person[] people, String subject){
        List<Teacher> teachersSub = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getSubject().contains(subject)){
                    teachersSub.add(teacher);
                }
            }
        }return teachersSub;
    }

    @Override
    public String getCommunityStatus() {
        return String.valueOf(isActive);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", categoryTeacher='" + categoryTeacher + '\'' +
                ", isActive=" + isActive +
                "} " + super.toString();
    }
}
