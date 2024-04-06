package org.example.java240327_Taski1;

public class Manager extends Employee{
    int subordinatesCount;
    public Manager(String name, String position, double salary) {
        super(name, position, salary);
    }

    public Manager(String name, String position, double salary, int subordinatesCount) {
        super(name, position, salary);
        this.subordinatesCount = subordinatesCount;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "subordinatesCount=" + subordinatesCount +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
    public  double calculateBonus(double salary) {
        double bonus2 = salary /100*5 +  salary /100*2* subordinatesCount;
        return bonus2;
    }
}
