package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.app.Application;

//add this line to manifest
//android:name=".MyApplication"
public class MyApplication extends Application {

    private static boolean appVisible;

    public static boolean isAppVisible() {
        return appVisible;
    }

    public static void appResume(){
        appVisible = true;
    }

    public static void appPause(){
        appVisible = false;
    }
}
