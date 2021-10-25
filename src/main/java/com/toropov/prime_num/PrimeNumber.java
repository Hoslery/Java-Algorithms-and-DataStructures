package com.toropov.prime_num;

public class PrimeNumber {
    public static void main(String[]args){
        System.out.print("Простые числа:");
        for (int i = 0; i < 1000; i++) {
            if(isPrime(i))
                System.out.print(" " + i);
        }

        System.out.print("\nПростые числа(оптимизация):");
        for (int i = 0; i < 1000; i++) {
            if(isPrimeOptimized(i))
                System.out.print(" " + i);
        }
    }

    public static boolean isPrime(int number){
        if(number<2)
            return false;

        for (int i = 2; i*i <= number; i++) {
            if(number % i ==0)
                return false;
        }
        return true;
    }

    public static boolean isPrimeOptimized(int number){
        if(number<2)
            return false;

        if(number % 2 == 0)
            return number == 2;

        if(number % 3 == 0)
            return number == 3;

        for (int i = 5; i*i <= number; i+=6) {
            if(number % i ==0 || number % (i+2) == 0)
                return false;
        }
        return true;
    }
}
