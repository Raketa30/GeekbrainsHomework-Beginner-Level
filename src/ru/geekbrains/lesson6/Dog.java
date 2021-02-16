package ru.geekbrains.lesson6;

public class Dog extends Animal {
    private static int counter = 0;

    public Dog(String name) {
        super(name);
        counter++;
    }

    public static void printDogCounter() {
        System.out.println("Total dogs: " + counter);
    }

    @Override
    public void run(int distance) {
        if (distance == 0) {
            System.out.printf("Пёсель %s стоит на месте%n", getName());

        } else if (distance <= 500 && distance > 0) {
            System.out.printf("Пес %s пробежал %d метров.%n", getName(), distance);

        } else {
            System.out.printf("Пес %s пробежал 500 метров и устал%n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        if (distance == 0) {
            System.out.printf("Пес %s не поплыл%n", getName());

        } else if (distance <= 10 && distance > 0) {
            System.out.printf("Песель %s проплыл %d метров.%n", getName(), distance);

        } else {
            System.out.printf("Пес %s проплыл 10 метров и устал%n", getName());
        }
    }
}
