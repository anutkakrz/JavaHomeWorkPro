package org.example.java240410;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Car {
private BrandCar brandCar;
private int quantityDoors;
private boolean isSport;
private int power;
private int price;
private int yearProduce;
private Color color;

    @Override
    public String toString() {
        return "Car{" +
                "brandCar=" + brandCar +
                ", quantityDoors=" + quantityDoors +
                ", isSport=" + isSport +
                ", power=" + power +
                ", price=" + price +
                ", yearProduce=" + yearProduce +
                ", color=" + color +
                '}';
    }
}

