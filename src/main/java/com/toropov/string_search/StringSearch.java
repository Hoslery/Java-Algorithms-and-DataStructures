package com.toropov.string_search;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSearch {
    public static void main(String[]args){
        String text = "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";
        System.out.println("Native Search: "+ Arrays.toString(searchNative(text, sample).toArray()));
        System.out.println("Prefix function: "+ Arrays.toString(prefixFunction(sample)));
        System.out.println("Knuth-Morris-Pratt Search: "+ Arrays.toString(searchKMP(text, sample).toArray()));
    }


    public static ArrayList<Integer> searchNative(String text, String sample){
        ArrayList<Integer> foundPositions = new ArrayList<Integer>();
        for(int i = 0; i < text.length(); i++){
            int j=0;
            while(j < sample.length() && (i+j) < text.length() && sample.charAt(j) == text.charAt(i+j)){
                j++;
            }
            if(j == sample.length())
                foundPositions.add(i);
        }
        return foundPositions;
    }

    public static int[] prefixFunction(String sample){
        int [] value = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j=0;
            while(i+j<sample.length() && sample.charAt(j) == sample.charAt(i+j)){
                value[i+j]=Math.max(value[i+j],j+1);
                j++;
            }
        }
        return value;
    }

    public static ArrayList<Integer> searchKMP(String text,String sample){
        ArrayList<Integer> foundPositions = new ArrayList<Integer>();
        int [] prefixFunction = prefixFunction(sample);
        int j=0;
        int i=0;
        while(i<text.length()){
            if(sample.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if(j == sample.length()){
                foundPositions.add(i-j);
                j = prefixFunction[j-1];
            } else if(i<text.length() && sample.charAt(j) != text.charAt(i)) {
                if(j!=0){
                    j = prefixFunction[j-1];
                }
                else{
                    i+=1;
                }
            }
        }
        return foundPositions;
    }
}
