package org.example.java240327_Taski;

public class Auto extends Transport{
    private String engineType;
    public Auto(String name, int speed, String engineType) {
        super(name, speed);
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }


    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", speed= " + speed +
                " engineType= '" + engineType + '\'' +
                '}';
    }
}
