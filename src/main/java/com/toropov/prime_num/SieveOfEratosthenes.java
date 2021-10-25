package com.toropov.prime_num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[]args){
        int max = 1000;
        System.out.println("Простые числа до " + max + ": " + Arrays.toString(eratosthenesPrimes(max).toArray()));
    }

    public static List<Integer> eratosthenesPrimes(int max){
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime,true);
        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i*i <max ; i++) {
            if(isPrime[i]){
                for (int j = i*2; j <max ; j+=i) {
                    isPrime[j]=false;
                }
            }
        }

        for(int i =2; i< isPrime.length; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        return primes;
    }
}
