package com.toropov.second_minimal;

import java.util.Arrays;

public class SecondMinElement {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36,16};
        int min2 = searchSecondMin(array);
        System.out.println("Массив: " + Arrays.toString(array));
        if (min2 == Integer.MAX_VALUE)
            System.out.println("Второго по минимальности элемента в массиве НЕТ");
        else
            System.out.println("Второй по минимальности элемент в массиве: " + min2);
    }

    public static int searchSecondMin(int[] array){
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i=0; i<array.length;i++){
            if (array[i]< min){
                min2 = min;
                min = array[i];
            }
            else if (array[i]<min2 && array[i]!=min){
                min2 = array[i];
            }
        }
        return min2;
    }

}
