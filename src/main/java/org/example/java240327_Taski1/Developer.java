package org.example.java240327_Taski1;

public class Developer extends Employee{
    String programmingLanguage;
    public Developer(String name, String position, double salary) {
        super(name, position, salary);
    }

    public Developer(String name, String position, double salary, String programmingLanguage) {
        super(name, position, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double calculateBonus(double salary) {
        double bonus3 = 500;
        return bonus3;
    }
}
