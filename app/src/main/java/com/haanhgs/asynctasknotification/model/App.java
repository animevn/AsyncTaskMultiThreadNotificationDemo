package com.haanhgs.asynctasknotification.model;

import android.app.Application;

public class App extends Application {

    private static boolean visible;

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
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
