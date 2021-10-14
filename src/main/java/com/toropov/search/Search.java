package com.toropov.search;

import java.util.Arrays;

import static com.toropov.sort.BubbleSort.bubbleSort;

public class Search {

    public static void main(String[] args){
        int[]array = new int[]{64,42,73,41,31,53,16,24,57,42,74,55,36,16};
        bubbleSort(array);//для применения binarySearch массив должен быть отсортирован
        System.out.println(Arrays.toString(array));
        int elementToFind = 53;
        int indexOfSearch = searchLinear(array,elementToFind);
        if(indexOfSearch == -1){
            System.out.println("Линейный поиск: Элемента со значением " + elementToFind + " в массиве нет");
        }
        else{
            System.out.println("Линейный поиск: Элементу со значением " + elementToFind + " соответствует индекс =  " + indexOfSearch);
        }
        System.out.println("Бинарный поиск через рекурсию: индекс = " + searchBinaryRecursive(array,0,array.length-1,elementToFind));
        System.out.println("Бинарный поиск без рекурсии: индекс = " + searchBinary(array,elementToFind));
    }

    public static int searchLinear(int[]array,int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == elementToFind)
                return i;
        }
        return -1;
    }

    public static int searchBinaryRecursive(int[]array, int startIndex, int endIndex, int elementToFind){
        if(endIndex>=startIndex){
            int middleIndex = startIndex + (endIndex-startIndex)/2;
            if(array[middleIndex] == elementToFind)
                return middleIndex;
            if(array[middleIndex]>elementToFind){
                return searchBinaryRecursive(array, startIndex, middleIndex-1, elementToFind);
            }
            else{
                return searchBinaryRecursive(array, middleIndex+1, endIndex, elementToFind);
            }
        }
        return -1;
    }

    public static int searchBinary(int[]array, int elementToFind){
        int startIndex = 0;
        int endIndex = array.length-1;
        int middleIndex;
        while(endIndex>=startIndex){
            middleIndex = startIndex + (endIndex-startIndex)/2;

            if(array[middleIndex] == elementToFind)
                return middleIndex;
            if(array[middleIndex] > elementToFind){
                endIndex = middleIndex -1;
            }
            else {
                startIndex = middleIndex+1;
            }
        }
        return -1;
    }
}
