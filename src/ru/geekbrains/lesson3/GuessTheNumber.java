package ru.geekbrains.lesson3;
/*
Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

import java.util.Scanner;

public class GuessTheNumber {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean game = true;

    public static void main(String[] args) {
        while (game) {
            System.out.println("Угадай число от 0 до 9 с трёх попыток");
            System.out.println("Загадываем число....");

            int randomNumber = (int) (Math.random() * 10);

            System.out.println(randomNumber);

            play(randomNumber);

            game = playAgain();
        }
    }

    private static void play(int randomNumber) {
        for (int i = 3; i > 0; i--) {
            System.out.println("Количество попыток: " + i);
            System.out.println("Введите число от 0 до 9: ");

            int answer = scanner.nextInt();

            if (answer == randomNumber) {
                System.out.println("Поздравляем! Вы угадали число!");
                return;

            } else if (answer > randomNumber) {
                System.out.println("Введеное число, больше загаданного!");

            } else {
                System.out.println("Введеное число, меньше загаданного!");
            }
        }

        System.out.println("Попытки закончились, Вы проиграли :(");
    }

    private static boolean playAgain() {
        System.out.println("Сыграем еще? Введите: \n"
                + "1 -  для новой игры \n" +
                "0 - для выхода..");

        while (true) {
            String answer = scanner.next();

            if (answer.equals("1")) {
                System.out.println("Круто! Поехали снова!");
                return true;

            } else if (answer.equals("0")) {
                System.out.println("Спасибо! Досвидания!");
                scanner.close();
                return false;

            } else {
                System.out.println("Неправильный ввод, Введите: \n"
                        + "1 -  для новой игры \n" +
                        "0 - для выхода..");
            }
        }
    }

}
