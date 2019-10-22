package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.os.AsyncTask;

public class RunTask extends AsyncTask<Integer,Void, Integer> {

    private TaskObserver listener;

    public RunTask(TaskObserver listener){
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onTaskStart();
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        return Repo.calculate(integers[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        listener.onTaskFinished(integer);
    }
}
