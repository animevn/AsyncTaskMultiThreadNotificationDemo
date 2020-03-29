package com.haanhgs.asynctasknotification;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Repo {

    public static void hideKeyboard(View view){
        InputMethodManager manager = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (manager != null){
            manager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void setPortrait(Activity activity){
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static boolean isNaturalNumber(String number){
        try{
            return Integer.valueOf(number) >= 0;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isPrimeNumber(int number){
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        int range = (int)Math.sqrt(number) + 1;
        for (int i = 2; i < range; i++){
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int calculateNthPrime(int number){
        int prime = 0;
        int testNumber = 0;
        int numberOfPrimesFound = 0;
        while (numberOfPrimesFound < number){
            if (isPrimeNumber(testNumber)){
                numberOfPrimesFound ++;
                if (numberOfPrimesFound == number){
                    prime = testNumber;
                }else {
                    testNumber ++;
                }
            }else {
                testNumber ++;
            }
        }
        return prime;
    }

}
