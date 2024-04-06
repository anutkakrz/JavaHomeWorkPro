package org.example.java240327_Taski;

public class Bicycle extends Transport{
    String type;
    public Bicycle(String name, int speed) {
        super(name, speed);
    }

    public Bicycle(String name, int speed, String type) {
        super(name, speed);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "name= '" + name + '\'' +
                ", speed= " + speed +
                " type= '" + type + '\'' +
                '}';
    }
}
