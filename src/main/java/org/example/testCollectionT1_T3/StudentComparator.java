package org.example.testCollectionT1_T3;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Student> lastNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };
    public static Comparator<Student> nameComparatorAgeIdentical = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int ageComparison = Integer.compare(o1.getAge(), o2.getAge());
            if (ageComparison != 0) {
                return ageComparison;
            }
            return o1.getName().compareTo(o2.getName());
        }
    };


    public static Comparator<Student> multiLevelSort = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int  result = o1.getLastName().compareTo(o2.getLastName());
            if (result != 0) {
                return result;
            }
            result = o1.getName().compareTo(o2.getName());
            if (result != 0) {
                return result;
            }
            result = Integer.compare(o1.getAge(), o2.getAge());
            if (result != 0) {
                return result;
            }
            return result;
        }
    };
    public static Comparator<Student> titleGroupAgeSort = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int  result = o1.getGroup().getTitleGroup().compareTo(o2.getGroup().getTitleGroup());
            if (result != 0) {
                return result;
            }
            return Integer.compare(o1.getAge(), o2.getAge());

        }

    };

}
