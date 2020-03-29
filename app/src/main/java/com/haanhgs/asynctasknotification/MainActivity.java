package com.haanhgs.asynctasknotification;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etInput1)
    EditText etInput1;
    @BindView(R.id.bnCalculate1)
    Button bnCalculate1;
    @BindView(R.id.tvResult1)
    TextView tvResult1;
    @BindView(R.id.etInput2)
    EditText etInput2;
    @BindView(R.id.bnCalculate2)
    Button bnCalculate2;
    @BindView(R.id.tvResult2)
    TextView tvResult2;
    @BindView(R.id.etInput3)
    EditText etInput3;
    @BindView(R.id.bnCalculate3)
    Button bnCalculate3;
    @BindView(R.id.tvResult3)
    TextView tvResult3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Repo.setPortrait(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.pause();
    }

    private void prepareTaskStarted(Button bn, EditText et, TextView tv){
        bn.setEnabled(false);
        et.setEnabled(false);
        et.setText("");
        tv.setText(R.string.waiting_result);
    }

    private void updateViewsTaskFinished(Button bn, EditText et, TextView tv, String message){
        bn.setEnabled(true);
        et.setEnabled(true);
        tv.setText(message);
    }

    private void runTask(View view, EditText et, TextView tv){
        int input = Integer.parseInt(et.getText().toString());
        Repo.hideKeyboard(view);
        Button bn = (Button)view;
        Task task = new Task();
        task.setListner(new TaskObserver() {
            @Override
            public void onPreTask() {
                prepareTaskStarted(bn, et, tv);
            }
            @Override
            public void onPostTask(int number, long time) {
                String message = "The prime number " + input + "th is " + number + "\n"
                        + "Calculated in " + time + " milisecs";
                updateViewsTaskFinished(bn, et, tv, message);
                Notification notification = new Notification(MainActivity.this, number, message);
                notification.createNotification();
            }
        });
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, input);
    }

    private void handleButton(View view, EditText et, TextView tv){
        if (Repo.isNaturalNumber(et.getText().toString())){
            runTask(view, et, tv);
        }else {
            tv.setText(R.string.number_invalid);
        }
    }

    @OnClick({R.id.bnCalculate1, R.id.bnCalculate2, R.id.bnCalculate3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnCalculate1:
                handleButton(view, etInput1, tvResult1);
                break;
            case R.id.bnCalculate2:
                handleButton(view, etInput2, tvResult2);
                break;
            case R.id.bnCalculate3:
                handleButton(view, etInput3, tvResult3);
                break;
        }
    }

}
