package ru.geekbrains.lesson6;

public abstract class Animal {
    private String name;
    private static int counter = 0;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static void printAnimalCounter() {
        System.out.println("Total animals: " + counter);
    }

    public String getName() {
        return name;
    }
}
