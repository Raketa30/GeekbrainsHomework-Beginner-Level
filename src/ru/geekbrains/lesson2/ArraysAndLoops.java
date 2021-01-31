package ru.geekbrains.lesson2;

import java.util.Arrays;

public class ArraysAndLoops {
    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Task 1");
        System.out.println(Arrays.toString(change0to1(firstArray)));

//        2. Задать пустой целочисленный массив размером 8.
//        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int size = 8;
        System.out.println("Task 2");
        System.out.println(Arrays.toString(fillArray(size)));
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

    private static int[] fillArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i * 3;
        }

        return arr;
    }
}
