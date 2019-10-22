package com.haanhgs.asynctaskmultithreadnotificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }




}
