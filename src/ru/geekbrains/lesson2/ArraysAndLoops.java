package ru.geekbrains.lesson2;

import java.util.Arrays;

public class ArraysAndLoops {
    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(change0to1(firstArray)));
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
}
