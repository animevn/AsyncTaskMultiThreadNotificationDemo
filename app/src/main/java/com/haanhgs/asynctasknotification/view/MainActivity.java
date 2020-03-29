package com.haanhgs.asynctasknotification.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.haanhgs.asynctasknotification.model.App;
import com.haanhgs.asynctasknotification.R;
import com.haanhgs.asynctasknotification.viewmodel.MyViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
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

    private MyViewModel viewModel;

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getData().observe(this, model -> {
            if (model.getPrime1() != null){
                tvResult1.setText(model.getMessage1());
            }else {
                tvResult1.setText(R.string.tvResult);
            }

            if (model.getPrime2() != null){
                tvResult2.setText(model.getMessage2());
            }else {
                tvResult2.setText(R.string.tvResult);
            }

            if (model.getPrime3() != null){
                tvResult3.setText(model.getMessage3());
            }else {
                tvResult3.setText(R.string.tvResult);
            }

            bnCalculate1.setEnabled(!model.isRunningThread1());
            bnCalculate2.setEnabled(!model.isRunningThread2());
            bnCalculate3.setEnabled(!model.isRunningThread3());

        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewModel();
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

    private void handleButton(View view, EditText et, int thread){
        if (Helper.isNaturalNumber(et.getText().toString())){
            Helper.hideKeyboard(view);
            int input = Integer.parseInt(et.getText().toString());
            viewModel.calculate(input, thread);
            et.setText("");
        }else {
            Toast.makeText(this, "invalid number", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick({R.id.bnCalculate1, R.id.bnCalculate2, R.id.bnCalculate3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnCalculate1:
                handleButton(view, etInput1, 1);
                break;
            case R.id.bnCalculate2:
                handleButton(view, etInput2, 2);
                break;
            case R.id.bnCalculate3:
                handleButton(view, etInput3, 3);
                break;
        }
    }

}
