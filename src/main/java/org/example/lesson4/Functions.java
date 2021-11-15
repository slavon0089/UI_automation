package org.example.lesson4;

public class Functions {
    public static boolean isNumberPrime(Integer number) {
        if (number <=0) return false;

        if(number <=2) return true;

        for (int i = 2; i <number-1 ; i++) {
            if (number % i ==0) return false;

        }
        return true;
    }
    //123321
    public static boolean isPalindrome(String word){
        if (word.length() <2) return true;

        if(word.charAt(0) != word.charAt(word.length()-1)) return false;

        return isPalindrome(word.substring(1,word.length()-1));


    }

}
