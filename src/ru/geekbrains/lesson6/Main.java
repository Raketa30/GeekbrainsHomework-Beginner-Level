package ru.geekbrains.lesson6;

public class Main {
    public static void main(String[] args) {
        Animal dogBobik = new Dog("Bobik");
        Animal dogBelka = new Dog("Belka");

        Animal catPeach = new Cat("Peach");
        Animal catGoma = new Cat("Goma");

        dogBobik.run(400);
        dogBobik.swim(10);
        dogBelka.run(550);
        dogBelka.swim(12);

        catGoma.run(23);
        catGoma.swim(9);
        catPeach.run(210);
        catPeach.swim(29);

        Animal.printAnimalCounter();
        Dog.printDogCounter();
        Cat.printCatCounter();

    }
}
