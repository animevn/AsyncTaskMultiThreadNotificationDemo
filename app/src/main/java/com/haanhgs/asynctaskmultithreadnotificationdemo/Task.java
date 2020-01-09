package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.os.AsyncTask;

public class Task extends AsyncTask<Integer, Void, Integer> {

    private TaskObserver listner;

    public void setListner(TaskObserver listner) {
        this.listner = listner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listner.onPreTask();
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        return Repo.calculateNthPrime(integers[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        listner.onPostTask(integer);
    }
}
