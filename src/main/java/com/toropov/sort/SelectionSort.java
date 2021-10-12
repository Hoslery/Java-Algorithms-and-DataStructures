package com.toropov.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        selectionSort(array);
        System.out.println("Selection Sort: " + Arrays.toString(array));
    }


    public static void selectionSort(int[] array){
        for(int step = 0;step<array.length;step++){
            int indexOfMin = searchIndexOfMin(array,step);
            int tmp = array[step];
            array[step] = array[indexOfMin];
            array[indexOfMin] = tmp;
        }
    }

    public static int searchIndexOfMin(int[] array,int step){
        int minIndex = step;
        int min = array[step];
        for (int i=step+1; i<array.length;i++){
            if (array[i]< min){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}
