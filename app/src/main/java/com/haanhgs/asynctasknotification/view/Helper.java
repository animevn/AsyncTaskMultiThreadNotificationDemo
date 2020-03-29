package com.haanhgs.asynctasknotification.view;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Helper {

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
            return Integer.valueOf(number) > 0;
        }catch (NumberFormatException e){
            return false;
        }
    }


}
