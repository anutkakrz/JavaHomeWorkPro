package org.example.testCollectionT3;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class Student extends Person implements Identifiable, CommunityMember{
    private int studentID;
    private boolean isActive;

    public Student(String name, String lastName, int age, int studentID, boolean isActive) {
        super(name, lastName, age);
        this.studentID = studentID;
        this.isActive = isActive;
    }

    public Student(int studentID, boolean isActive) {
        this.studentID = studentID;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                "isActive: "+ isActive+
                "} " + super.toString();
    }

    @Override
    public String getIdentity() {
        return "Student {" +
                "studentID = " + studentID +
                ", Name: "+super.getName()+
                ", LastName: "+super.getLastName()+
                " } ";
    }

    @Override
    public String describe(){
        return "Student {" +
                " Name: "+getName()+
                ", LastName: "+getLastName()+
                ", Age: "+getAge()+
                "studentID = " + studentID +
                " } ";
    }

    @Override
    public String getCommunityStatus() {
        return String.valueOf(isActive);
    }
}
