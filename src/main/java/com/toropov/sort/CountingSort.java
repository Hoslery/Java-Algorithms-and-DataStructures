package com.toropov.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        countingSort(array);
        System.out.println("Counting Sort: " + Arrays.toString(array));
    }

    public static void countingSort(int[]array){
        final int MAX_VALUE = 100;
        int[] count = new int [MAX_VALUE];

        for (int i = 0; i < array.length ; i++) {
            count[array[i]] += 1;
        }

        int arrayIndex = 0;
        for (int i = 0; i < count.length ; i++) {
            for (int j = 0; j <count[i] ; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }

    }

}
