package org.example.testCollectionT3;

import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int age;

    public String describe() {
        return "Person: "+"{" + "Name: "+getName()+
                ", LastName: "+getLastName()+
                ", Age: "+getAge()+
                " } ";
    }

}
