package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY_AREA = '•';
    private static final char USER_POINT = 'X';
    private static final char AI_POINT = 'O';
    private static final int SIZE = 3;
    private static final int LENGTH = 3;
    private static char[][] field;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initNewGameArea();
        printArea(field);
        game();
    }

    private static void game() {
        while (true) {
            doHumanStep();
            printArea(field);

            if (isHorizontalWin(USER_POINT) || isVerticalWin(USER_POINT) || isDiagonalWin(USER_POINT)) {
                System.out.println("Победил игрок");
                break;
            }

            if (isFullField()) {
                System.out.println("Ничья!");
                break;
            }

            doAiStep();
            printArea(field);

            if (isHorizontalWin(AI_POINT) || isVerticalWin(AI_POINT) || isDiagonalWin(AI_POINT)) {
                System.out.println("Победил ИИ!");
                break;
            }

            if (isFullField()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }

    private static void initNewGameArea() {
        field = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY_AREA;
            }
        }
    }

    private static void printArea(char[][] matrix) {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }

    private static void doHumanStep() {
        System.out.println("Введите два числа через пробел:");
        int x;
        int y;

        do {
            while (true) {
                String step = scanner.nextLine();
                if (checkUserInput(step)) {
                    String[] steps = step.split("\\s+");
                    x = Integer.parseInt(steps[0]) - 1;
                    y = Integer.parseInt(steps[1]) - 1;
                    break;
                }
                System.out.println("Повторите ввод:");
            }
        } while (isValidCell(y, x));
        field[y][x] = USER_POINT;
    }

    private static boolean checkUserInput(String step) {
        String regex = "\\d+\\s+\\d+";
        return step.matches(regex);
    }

    private static void doAiStep() {
        System.out.println("Ход ИИ..");
        Random random = new Random();

        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

        } while (isValidCell(y, x));

        field[y][x] = AI_POINT;
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
    }

    private static boolean isValidCell(int y, int x) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Повторите ввод:");
            return true;
        }
        return field[y][x] != EMPTY_AREA;
    }

    private static boolean isFullField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY_AREA) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int random(int first, int second) {
        Random random = new Random();
        int coin = random.nextInt(2);

        if (coin == 0) {
            return first;
        }
        return second;
    }

    private static int flipCoin() {
        Random random = new Random();
        return random.nextInt(2);
    }

    //Методы проверки выиграша
    private static boolean isVerticalWin(char user) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;

            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == user) {
                    counter++;
                }
                if (counter == LENGTH) {
                    return true;
                }
                if (field[j][i] != user) {
                    counter = 0;
                }
            }
        }

        return false;
    }

    private static boolean isHorizontalWin(char user) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;

            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == user) {
                    counter++;
                }
                if (counter == LENGTH) {
                    return true;
                }
                if (field[i][j] != user) {
                    counter = 0;
                }
            }
        }

        return false;
    }

    private static boolean isDiagonalWin(char user) {
        int index = SIZE - LENGTH;

        for (int i = 0; i <= index; i++) {
            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            int counter4 = 0;

            int leftRightIndex = i;
            int rightLeftIndex = SIZE - 1; // 4
            for (int j = 0; j < SIZE - i; j++) {
                if (field[leftRightIndex][j] == user) {
                    counter1++;
                    if (counter1 == LENGTH) {
                        return true;
                    }
                } else {
                    counter1 = 0;
                }

                if (field[j][leftRightIndex] == user) {
                    counter2++;
                    if (counter2 == LENGTH) {
                        return true;
                    }
                } else {
                    counter2 = 0;
                }

                if (field[j][rightLeftIndex] == user) {
                    counter3++;
                    if (counter3 == LENGTH) {
                        return true;
                    }
                } else {
                    counter3 = 0;
                }

                if (field[leftRightIndex][rightLeftIndex] == user) {
                    counter4++;
                    if (counter4 == LENGTH) {
                        return true;
                    }
                } else {
                    counter4 = 0;
                }

                leftRightIndex++;
                rightLeftIndex--;
            }
        }

        return false;
    }

    //Методы для ИИ

    private static int[] checkVertLine(char user) {
        int[] axises = new int[2];
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;

            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == user) {
                    counter++;
                }
                if (counter == 2) {
                    axises[0] = j;
                    axises[1] = i;
                    return axises;
                }
                if (field[j][i] != user) {
                    counter = 0;
                }
            }
        }

        return null;
    }

    private static int[] checkHorizLine(char user) {
        int[] axises = new int[2];
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;

            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == user) {
                    counter++;
                }
                if (counter >= 2) {
                    axises[0] = j + 1;
                    axises[1] = i + 1;
                    return axises;
                }
                if (field[i][j] != user) {
                    counter = 0;
                }
            }
        }

        return null;
    }

    private static int[] checkDiagonalLine(char user) {
        int[] axises = new int[2];
        int index = SIZE - LENGTH;

        for (int i = 0; i <= index; i++) {
            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            int counter4 = 0;

            int leftRightIndex = i;
            int rightLeftIndex = SIZE - 1; // 4
            for (int j = 0; j < SIZE - i; j++) {
                if (field[leftRightIndex][j] == user) {
                    counter1++;
                    if (counter1 >= 2) {
                        axises[0] = leftRightIndex + 1;
                        axises[1] = j + 1;
                    }
                } else {
                    counter1 = 0;
                }

                if (field[j][leftRightIndex] == user) {
                    counter2++;
                    if (counter2 >= 2) {
                        axises[0] = j + 1;
                        axises[1] = leftRightIndex + 1;
                        return axises;
                    }
                } else {
                    counter2 = 0;
                }

                if (field[j][rightLeftIndex] == user) {
                    counter3++;
                    if (counter3 >= 2) {
                        axises[0] = j + 1;
                        axises[1] = leftRightIndex + 1;
                        return axises;
                    }
                } else {
                    counter3 = 0;
                }

                if (field[leftRightIndex][rightLeftIndex] == user) {
                    counter4++;
                    if (counter4 >= 2) {
                        axises[0] = leftRightIndex + 1;
                        axises[1] = leftRightIndex + 1;
                        return axises;
                    }
                } else {
                    counter4 = 0;
                }

                leftRightIndex++;
                rightLeftIndex--;
            }
        }

        return null;
    }

}
