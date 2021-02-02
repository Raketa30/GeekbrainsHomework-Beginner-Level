package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

/*
* Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
"nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Угаданные в прошлые ответы буквы запоминать не надо. То есть при следующем ответе: carpet (ковер, не фрукт, но это всего лишь пример), будет выведено:
####e##########

Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только буквы в нижнем регистре.
 */
public class GuessTheWord {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean game = true;
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        while (game) {
            String randomWord = takeRandomWord();
            System.out.println(randomWord);
            checkWord(randomWord);

            game = playAgain();
        }
    }

    private static void checkWord(String randomWord) {
        System.out.println("Введите слово:");

        while(true) {
            String userWord = scanner.next();
            if (randomWord.equals(userWord)) {
                System.out.println("Верно! Вы победили!");
                return;
            } else {
                compareWords(randomWord, userWord);
            }
        }
    }

    private static void compareWords(String randomWord, String userWord) {
        char[] rndWordCharArray = randomWord.toCharArray();
        char[] usrWordCharArray = userWord.toCharArray();

        for(int i = 0; i < 15; i++) {
            try {
                if(usrWordCharArray[i] == rndWordCharArray[i]) {
                    System.out.print(rndWordCharArray[i]);
                } else {
                    System.out.print("#");
                }
            } catch (Exception e) {
                System.out.print("#");
            }
        }
        System.out.println();
    }

    private static String takeRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    private static boolean playAgain() {
        System.out.println("Сыграем еще? Введите: \n"
                + "Да -  для новой игры \n" +
                "Нет - для выхода..");

        while (true) {
            String answer = scanner.next();

            if (answer.toLowerCase().equals("да")) {
                System.out.println("Круто! Поехали снова!");
                return true;

            } else if (answer.toLowerCase().equals("нет")) {
                System.out.println("Спасибо! Досвидания!");
                scanner.close();
                return false;

            } else {
                System.out.println("Неправильный ввод, Введите: \n"
                        + "Да -  для новой игры \n" +
                        "Нет - для выхода..");
            }
        }
    }
}
