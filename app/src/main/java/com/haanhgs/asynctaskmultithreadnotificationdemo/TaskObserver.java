package com.haanhgs.asynctaskmultithreadnotificationdemo;

public interface TaskObserver {
    void onTaskStart();
    void onTaskFinished(int number);
}
