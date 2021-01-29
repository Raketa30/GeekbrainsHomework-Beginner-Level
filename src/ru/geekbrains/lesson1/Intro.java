package ru.geekbrains.lesson1;
//  1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
public class Intro {
    public static void main(String[] args) {
//      2. Создать переменные всех пройденных типов данных и инициализировать их значения.

        byte b = 127;
        short s = 32766;

        char ch = 'a';
        char ch2 = 97;
        char ch3 = '\u0061';

        int i = 3253443;
        long l = 1000_000_000_000_000L;
        float f = 10.10f;
        double d = 22.234;
        boolean bln = true;

        String str = "Hello geekbrains!";
    }

//    3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//    где a, b, c, d – аргументы этого метода, имеющие тип float.

    private static float expressionCalculating(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

//    4. Написать метод, принимающий на вход два целых числа и проверяющий,
//     что их сумма лежит в пределах от 10 до 20 (включительно),
//     если да – вернуть true, в противном случае – false.

    private static boolean isMoreThanTenAndLessThenTwenty(int firstDigit, int secondDigit) {
        int sum = firstDigit + secondDigit;
        return sum >= 10 && sum <= 20;
    }

//    5. Написать метод, которому в качестве параметра передается целое число,
//    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
//    Замечание: ноль считаем положительным числом.

    private static void printPositiveOrNegative(int digit) {
        if (digit >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

//    6. Написать метод, которому в качестве параметра передается целое число.
//    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

    private static boolean printTrueOrFalse(int digit) {
        return digit < 0;
    }
}
