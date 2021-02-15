package ru.geekbrains.lesson7;

public class Plate {
    private int food;
    private boolean isEmpty;

    public Plate(int food) {
        this.food = food;
        isEmpty = food <= 0;
    }

    public int decreaseFood(int appetite) {
        int power = 0;

        if(appetite <= food) {
            power = appetite;
            food -= appetite;

        } else {
            if(food != 0 && food > 0) {
                power = Math.abs(food - appetite);
                food = 0;
                isEmpty = true;
            }
        }

        return power;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public void fillPlate(int wiskas) {
        food += wiskas;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

}
