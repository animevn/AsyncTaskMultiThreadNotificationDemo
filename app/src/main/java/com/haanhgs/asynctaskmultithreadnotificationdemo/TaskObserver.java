package com.haanhgs.asynctaskmultithreadnotificationdemo;

public interface TaskObserver {
    void onPreTask();
    void onPostTask(int number, long time);
}
