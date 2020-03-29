package com.haanhgs.asynctasknotification;

public interface TaskObserver {
    void onPreTask();
    void onPostTask(int number, long time);
}
