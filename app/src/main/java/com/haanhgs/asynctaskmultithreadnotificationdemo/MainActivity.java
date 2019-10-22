package com.haanhgs.asynctaskmultithreadnotificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult1;
    private TextView tvResult2;
    private TextView tvResult3;

    private Button bnCal1;
    private Button bnCal2;
    private Button bnCal3;

    private EditText etInput1;
    private EditText etInput2;
    private EditText etInput3;

    private void forcePortraitMode(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void initViews(){
        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        bnCal1 = findViewById(R.id.bnCalculate1);
        bnCal2 = findViewById(R.id.bnCalculate2);
        bnCal3 = findViewById(R.id.bnCalculate3);
        etInput1 = findViewById(R.id.etInput1);
        etInput2 = findViewById(R.id.etInput2);
        etInput3 = findViewById(R.id.etInput3);
    }

    private void hideKeyboard(View view){
        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        if (manager != null){
            manager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void runTask(View view, final Button bn, final EditText et, final TextView tv){
        final int input = Integer.parseInt(et.getText().toString());
        hideKeyboard(view);
        RunTask runTask = new RunTask(new TaskObserver() {
            private long start;
            @Override
            public void onTaskStart() {
                bn.setEnabled(false);
                et.setEnabled(false);
                tv.setText(R.string.tvResult);
                start = System.currentTimeMillis();
            }

            @Override
            public void onTaskFinished(int number) {
                bn.setEnabled(true);
                et.setEnabled(true);
                long time = System.currentTimeMillis() - start;
                String string = "The prime number " + input + " is " + number + "\n"
                        + "Calculated in " + time + " milisecs";
                tv.setText(string);
            }
        });
        runTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, input);
    }

    private void handleThread1(){
        bnCal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Repo.isNumber(etInput1.getText().toString())){
                    runTask(v, bnCal1, etInput1, tvResult1);
                }
            }
        });
    }

    private void handleThread2(){
        bnCal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Repo.isNumber(etInput2.getText().toString())){
                    runTask(v, bnCal2, etInput2, tvResult2);
                }
            }
        });
    }

    private void handleThread3(){
        bnCal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Repo.isNumber(etInput3.getText().toString())){
                    runTask(v, bnCal3, etInput3, tvResult3);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forcePortraitMode();
        initViews();
        handleThread1();
        handleThread2();
        handleThread3();

    }




}
