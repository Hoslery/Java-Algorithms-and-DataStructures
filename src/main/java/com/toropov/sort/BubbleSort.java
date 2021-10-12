package com.toropov.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        bubbleSort(array);
        System.out.println("Bubble sort: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i=1; i<array.length;i++){
                if (array[i]< array[i-1]){
                    swap(array, i,i-1);
                    isSorted = false;
                }
            }
        }
    }

    public static void swap(int[]array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
