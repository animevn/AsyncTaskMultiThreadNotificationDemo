package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.app.Application;

public class App extends Application {

    private static boolean isVisible;

    public static boolean isIsVisible() {
        return isVisible;
    }

    public static void resume(){
        isVisible = true;
    }

    public static void pause(){
        isVisible = false;
    }
}
