package ru.geekbrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean game = true;
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в игру \"Угадай слово!\"");
        System.out.println("Для выхода введите - exit");
        while (game) {
            System.out.println("Загадываем...");
            String randomWord = takeRandomWord();
            checkWord(randomWord);

            game = playAgain();
        }
    }

    private static void checkWord(String randomWord) throws IOException {
        String userWord;

        while(true) {
            System.out.println("Введите слово:");
            userWord = reader.readLine();

            if (randomWord.equals(userWord)) {
                System.out.println("Верно! Вы победили!");
                return;

            } else if (userWord.equals("exit")) {
                System.out.println("Загаданное слово - " + randomWord);
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

    private static boolean playAgain() throws IOException {
        System.out.println("Сыграем еще? Введите: \n"
                + "Yes -  для новой игры \n" +
                "No - для выхода..");

        while (true) {
            String answer = reader.readLine();

            if (answer.toLowerCase().equals("yes")) {
                System.out.println("Круто! Поехали снова!");
                return true;

            } else if (answer.toLowerCase().equals("no")) {
                System.out.println("Спасибо! Досвидания!");
                reader.close();
                return false;

            } else {
                System.out.println("Неправильный ввод, Введите: \n"
                        + "Yes -  для новой игры \n" +
                        "No - для выхода..");
            }
        }
    }
}
