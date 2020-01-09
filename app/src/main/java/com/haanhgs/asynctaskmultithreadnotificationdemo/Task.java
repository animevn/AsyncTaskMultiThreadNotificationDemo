package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.os.AsyncTask;

public class Task extends AsyncTask<Integer, Void, Integer> {

    private TaskObserver listner;
    private long start;

    public void setListner(TaskObserver listner) {
        this.listner = listner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listner.onPreTask();
        start = System.currentTimeMillis();
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        return Repo.calculateNthPrime(integers[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        long time = System.currentTimeMillis() - start;
        listner.onPostTask(integer, time);
    }
}
