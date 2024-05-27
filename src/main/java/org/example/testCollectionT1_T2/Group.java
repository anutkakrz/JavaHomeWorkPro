package org.example.testCollectionT1_T2;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Group {
    private String titleGroup;
    private List<Student> studentsInGroupe;

    @Override
    public String toString() {
        return titleGroup;
    }
}

