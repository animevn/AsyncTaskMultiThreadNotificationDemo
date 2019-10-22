package com.haanhgs.asynctaskmultithreadnotificationdemo;

public class Repo {

    public static boolean isNumber(String number){
        try{
            return Integer.parseInt(number) > 0 && Integer.parseInt(number) < 1000000000;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }else if (number == 2 || number == 3){
            return true;
        }else {
            for (int i = 2; i <= Math.sqrt(number); i++){
                if (number % i == 0) return  false;
            }
            return true;
        }
    }

    public static int calculate(int number){
        int prime = 0;
        int testNumber = 0;
        int numberOfPrimesFound = 0;
        while (numberOfPrimesFound < number){
            if (isPrime(testNumber)){
                numberOfPrimesFound ++;
                if (numberOfPrimesFound == number){
                    prime = testNumber;
                }else {
                    testNumber ++;
                }
            }else {
                testNumber++;
            }
        }
        return prime;
    }
}
