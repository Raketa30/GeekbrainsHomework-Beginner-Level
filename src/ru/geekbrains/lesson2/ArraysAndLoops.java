package ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class ArraysAndLoops {
    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] firstArray = fillArray(10, 2);
        System.out.println("Task 1");
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(change0to1(firstArray)));
        System.out.println();

//        2. Задать пустой целочисленный массив размером 8.
//        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int size = 8;
        System.out.println("Task 2");
        System.out.println(Arrays.toString(increaseByThree(size)));
        System.out.println();

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//        пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Task 3");
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(findDigitsLowerThanSix(thirdArray)));
        System.out.println();

//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int len = 10;
        System.out.println("Task 4");
        printMatrix(fillDiagonalByOne(len));
        System.out.println();

//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] fifthArray = fillArray(12, 50);
        System.out.println("Task 5");
        System.out.println(Arrays.toString(fifthArray));
        findMinAndMax(fifthArray);
        System.out.println();


//        6.** Написать метод, в который передается не пустой одномерный целочисленный массив,
//        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.
        System.out.println("Task 6");
        int[] sixTestArrayOne = fillArray(8, 10);
        System.out.println(Arrays.toString(sixTestArrayOne));
        System.out.println(checkBalance(sixTestArrayOne));

        int[] sixTestArrayTwo = fillArray(6, 8);
        System.out.println(Arrays.toString(sixTestArrayTwo));
        System.out.println(checkBalance(sixTestArrayTwo));

        int[] sixTestArrayThree = fillArray(10, 5);
        System.out.println(Arrays.toString(sixTestArrayThree));
        System.out.println(checkBalance(sixTestArrayThree));

        int[] sixTestArrayFour = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(Arrays.toString(sixTestArrayFour));
        System.out.println(checkBalance(sixTestArrayFour));

        int[] sixTestArrayFive = {1, 1, 1, 2, 1};
        System.out.println(Arrays.toString(sixTestArrayFive));
        System.out.println(checkBalance(sixTestArrayFive));


//        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//        или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
//        Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//        [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

        System.out.println("Task 7");
        int[] sevenArray = fillArray(10, 10);
        int range = shiftRandom(11);
        System.out.println(Arrays.toString(sevenArray));
        shiftArray(sevenArray, range);
        System.out.println(Arrays.toString(sevenArray));


    }

    private static int[] change0to1(int[] arr){
        int[] changed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                changed[i] = 1;
            } else {
                changed[i] = 0;
            }
        }

        return changed;
    }

    private static int[] increaseByThree(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i * 3;
        }

        return arr;
    }

    private static int[] findDigitsLowerThanSix(int[] arr) {
        int[] changedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++)  {
            if (arr[i] < 6) {
                changedArr[i] = arr[i] * 2;
            } else {
                changedArr[i] = arr[i];
            }
        }

        return changedArr;
    }

    private static int[][] fillDiagonalByOne(int len) {
        int[][] array = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0, k = len - 1; j < len; j++, k--) {
                if(j == i) {
                    array[i][j] = 1;
                    array[i][k] = 1;
                }
            }
        }
        return array;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void findMinAndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i : arr) {
            if (i < min) {
                min = i;
            }

            if(i > max) {
                max = i;
            }
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }

    private static int[] fillArray(int size, int maxRange) {
        int[] arr = new int[size];
        Random random = new Random();

        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxRange);
        }

        return arr;
    }

    private static boolean checkBalance(int[] arr) {
        boolean flag = false;
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }

        int nextSum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            nextSum += arr[i];
            sum -= arr[i];

            if(sum == nextSum) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    private static int shiftRandom(int range) {
        Random random = new Random();
        return random.nextInt(range) - random.nextInt(range);
    }

    private static void shiftArray(int[] arr, int shiftRange) {
        if (shiftRange == 0) {
            System.out.println("do nothing!");
            return;
        }
        if (shiftRange > 0) {
            System.out.println("-> " + shiftRange);
            for (int i = 0; i < shiftRange; i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];

                }
                arr[0] = temp;
            }
        } else {
            System.out.println("<- " + shiftRange);
            for (int i = shiftRange; i < 0; i++) {
                int temp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];

                }
                arr[arr.length - 1] = temp;
            }
        }
    }
}
