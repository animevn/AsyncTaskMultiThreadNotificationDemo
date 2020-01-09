package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.app.Application;

public class App extends Application {

    private static boolean visible;

    public static boolean isVisible() {
        return visible;
    }

    public static void resume(){
        visible = true;
    }

    public static void pause(){
        visible = false;
    }
}
