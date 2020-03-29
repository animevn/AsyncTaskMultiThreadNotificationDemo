package com.haanhgs.asynctasknotification.viewmodel;

import android.app.Application;
import com.haanhgs.asynctasknotification.model.Model;
import com.haanhgs.asynctasknotification.model.Repo;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {

    private final Repo repo;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo(application.getApplicationContext());
    }

    public LiveData<Model> getData(){
        return repo.getLiveData();
    }

    public void calculate(int number, int thread){
        repo.calculate(number, thread);
    }
}
