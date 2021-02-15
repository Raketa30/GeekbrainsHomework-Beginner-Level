package ru.geekbrains.lesson7;
/*
 * 1.Расширить задачу про котов и тарелки с едой.
 *
 * 2.Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества
 *  еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 *
 * 3.Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 *  Если коту удалось покушать (хватило еды), сытость = true.
 *
 * 4.Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
 *  то есть не может быть наполовину сыт (это сделано для упрощения логики программы). // я не упрощал
 *
 * 5.Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
 *  и потом вывести информацию о сытости котов в консоль.
 *
 * 6.Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = appetite == 0;
    }

    public void eat(Plate plate) {
        printCatHungryStatus(); // for test

        if (plate.isEmpty()) {
            System.out.println(name + " визжит по-кошачьи мяяу мяяяяу насыпь еды кожаный");

        } else {
            if (isFull) {
                System.out.println(name + " не голодный");

            } else {
                int energy = plate.decreaseFood(appetite);

                if (energy != 0) {
                    System.out.println(name + " съел " + energy + " корма");
                    appetite -= energy;

                    if (appetite != 0) {
                        System.out.println(name + " не наелся и агрессивно мяукает");
                        System.out.println("Насыпь еды, кожаный");

                    } else {
                        isFull = true;
                        System.out.println(name + " наелся и уснул.");
                    }
                }
            }
        }

        printCatHungryStatus(); //for test
        System.out.println();
    }

    private void printCatHungryStatus() {
        System.out.println("Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isFull=" + isFull +
                '}'
        );
    }
}
