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

        test();
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

//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
//    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

    private static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

//    8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    private static void isLeapYear(int year) {
        if (year == 0) {
            System.out.println(year + " год. Новая эра, хз че за год :)");

        } else if (year % 4 == 0 || year % 400 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.println(year + " - Не високосный год");

            } else {
                System.out.println(year + " - Високосный год");
            }

        } else {
            System.out.println(year + " - Не високосный год");
        }
    }

    private static void test() {
        System.out.println("3.");
        System.out.println(expressionCalculating(10.0f, 12.2f, 1.1f, 20.2f));

        System.out.println("4.");
        System.out.println(isMoreThanTenAndLessThenTwenty(5, 2));
        System.out.println(isMoreThanTenAndLessThenTwenty(5, 5));
        System.out.println(isMoreThanTenAndLessThenTwenty(5, 10));
        System.out.println(isMoreThanTenAndLessThenTwenty(10, 10));
        System.out.println(isMoreThanTenAndLessThenTwenty(10, 11));

        System.out.println("5.");
        printPositiveOrNegative(-1);
        printPositiveOrNegative(0);
        printPositiveOrNegative(2);

        System.out.println("6.");
        System.out.println(printTrueOrFalse(-1));
        System.out.println(printTrueOrFalse(0));
        System.out.println(printTrueOrFalse(3));

        System.out.println("7.");
        printName("Игорь Кульгачев");

        System.out.println("8.");
        isLeapYear(2021);
        isLeapYear(2016);
        isLeapYear(2000);
        isLeapYear(1900);
        isLeapYear(1800);
        isLeapYear(1600);
        isLeapYear(0);
        isLeapYear(1973);
    }
}
