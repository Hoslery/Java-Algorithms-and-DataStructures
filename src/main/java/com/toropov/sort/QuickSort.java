package com.toropov.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class QuickSort {
    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        Instant start = Instant.now();
        quickSort(array,0,array.length-1);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Quick Sort: " + Arrays.toString(array));
        System.out.println("Время выполнения: " + elapsed +" мс");
    }

    public static void quickSort(int[]array, int from, int to){
        if (from < to){
            int divideIndex = partition(array,from,to);
            quickSort(array,from,divideIndex-1);
            quickSort(array,divideIndex,to);
        }
    }

    public static int partition(int[]array,int from, int to){
        int leftIndex = from;
        int rightIndex = to;
        int supportEl = array[from + (to-from)/2];
        while(leftIndex<=rightIndex){
            while(array[leftIndex]<supportEl)
                leftIndex++;
            while (array[rightIndex]>supportEl)
                rightIndex--;
            if(leftIndex<=rightIndex){
                swap(array,leftIndex,rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap(int[]array,int leftIndex, int rightIndex){
        int tmp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = tmp;
    }

}
