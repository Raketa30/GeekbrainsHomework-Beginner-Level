package ru.geekbrains.lesson7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Plate plate;
    private static List<Cat> cats;

    static {
        plate = new Plate(100);
        cats = new ArrayList<>();

        cats.add(new Cat("Golodniy", 5));
        cats.add(new Cat("PochtiGolodniy", 10));
        cats.add(new Cat("Sytiy", 0));
        cats.add(new Cat("Murzik", 45));
        cats.add(new Cat("Dyryaviy", 55));
        cats.add(new Cat("Barsik", 5));
    }

    public static void main(String[] args) {
        plate.info();

        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
        }

        plate.fillPlate(100);
        plate.info();
    }
}
