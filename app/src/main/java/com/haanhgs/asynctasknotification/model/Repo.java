package com.haanhgs.asynctasknotification.model;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import androidx.lifecycle.MutableLiveData;

public class Repo {

    private final Context context;
    private final Model model = new Model();
    private final MutableLiveData<Model>liveData = new MutableLiveData<>();
    private static final ThreadPoolExecutor executor = (ThreadPoolExecutor)
            Executors.newFixedThreadPool(3);

    public Repo(Context context) {
        this.context = context;
        liveData.setValue(model);
    }

    public MutableLiveData<Model> getLiveData() {
        return liveData;
    }

    private boolean isPrimeNumber(int number){
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        int range = (int)Math.sqrt(number) + 1;
        for (int i = 2; i < range; i++){
            if (number % i == 0) return false;
        }
        return true;
    }

    private int calculateNthPrime(int number){
        int prime = 0;
        int testNumber = 0;
        int numberOfPrimesFound = 0;
        while (numberOfPrimesFound < number){
            if (isPrimeNumber(testNumber)){
                numberOfPrimesFound ++;
                if (numberOfPrimesFound == number){
                    prime = testNumber;
                }else {
                    testNumber ++;
                }
            }else {
                testNumber ++;
            }
        }
        return prime;
    }

    private void processApprovedNumber(int number, int thread){
        long start = System.currentTimeMillis();
        switch (thread){
            case 1:
                model.setPrime1(null);
                model.setRunningThread1(true);
                liveData.postValue(model);
                model.setPrime1(calculateNthPrime(number));
                break;
            case 2:
                model.setPrime2(null);
                model.setRunningThread2(true);
                liveData.postValue(model);
                model.setPrime2(calculateNthPrime(number));
                break;
            case 3:
                model.setPrime3(null);
                model.setRunningThread3(true);
                liveData.postValue(model);
                model.setPrime3(calculateNthPrime(number));
                break;
        }

        long duration = System.currentTimeMillis() - start;
        String message = "";

        switch (thread){
            case 1:
                model.setRunningThread1(false);
                message = "The prime number " + number + "th is " + model.getPrime1() + "\n"
                        + "Calculated in " + duration + " milisecs";
                model.setMessage1(message);
                break;
            case 2:
                model.setRunningThread2(false);
                message = "The prime number " + number + "th is " + model.getPrime2() + "\n"
                        + "Calculated in " + duration + " milisecs";
                model.setMessage2(message);
                break;
            case 3:
                model.setRunningThread3(false);
                message = "The prime number " + number + "th is " + model.getPrime3() + "\n"
                        + "Calculated in " + duration + " milisecs";
                model.setMessage3(message);
                break;
        }
        liveData.postValue(model);
        if (!App.isVisible()){
            Notification notification = new Notification(context, number, message);
            notification.createNotification();
        }
    }

    public void calculate(int number, int thread){
        executor.execute(() -> processApprovedNumber(number, thread));
    }

}
