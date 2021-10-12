package com.toropov.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        System.out.println("Merge Sort: ");
        System.out.println(Arrays.toString(array));
        mergeSort(array);
    }


    public static void mergeSort(int[]array){
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(Arrays.toString(currentSrc));
        }
    }


    public static void merge(int[] src1, int src1Start, int[] src2, int src2Start,int[] dest,
                             int destStart,int size ){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start+size,src1.length);
        int src2End = Math.min(src2Start+size,src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

}
