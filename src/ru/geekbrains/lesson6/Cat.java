package ru.geekbrains.lesson6;

public class Cat extends Animal{
    private static int counter = 0;

    public Cat(String name) {
        super(name);
        counter++;
    }

    public static void printCatCounter() {
        System.out.println("Total cats: " + counter);
    }

    @Override
    public void run(int distance) {
        if (distance == 0) {
            System.out.printf("Кот %s стоит на месте%n", getName());

        } else if (distance <= 200 && distance > 0) {
            System.out.printf("Кот %s пробежал %d метров.%n", getName(), distance);

        } else {
            System.out.printf("Кот %s пробежал 200 метров и лег%n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + getName() + " отказался плыть, потому что не умеет.");
    }
}
