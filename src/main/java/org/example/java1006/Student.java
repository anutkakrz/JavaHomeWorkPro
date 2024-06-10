package org.example.java1006;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    double grade; //средний балл студента.
    Enum major; //специальность студента.
    int year;// курс обучения студента.
    boolean fullTime; // статус обучения студента (очно/заочно).


}
