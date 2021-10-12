package com.toropov.minimal;

public class MinElement {

    public static void main(String []args){
        int []array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        int min = searchMin(array);
        System.out.println("Min el: " + min);
    }

    public static int searchMin(int[] array){
        int minIndex = 0;
        int min = array[0];
        for (int i=1; i<array.length;i++){
            if (array[i]< min){
                min = array[i];
                minIndex = i;
            }
        }
        return min;
    }
}
