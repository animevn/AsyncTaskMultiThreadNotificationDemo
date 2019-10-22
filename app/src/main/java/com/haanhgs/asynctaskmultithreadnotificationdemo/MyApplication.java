package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

//add this line to manifest
//android:name=".MyApplication"
public class MyApplication extends Application {

    private static boolean appVisible;
    private static WeakReference<Context> context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = new WeakReference<>(getApplicationContext());
    }

    public static Context context() {
        return context.get();
    }

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
