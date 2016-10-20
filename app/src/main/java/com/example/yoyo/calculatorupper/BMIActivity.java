package com.example.yoyo.calculatorupper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {
    EditText et_kg,et_cm;
    TextView show_bmi;
    Button bmi_calculate;
    public void init(){
        et_kg = (EditText)findViewById(R.id.et_kg);
        et_cm = (EditText)findViewById(R.id.et_cm);
        show_bmi = (TextView) findViewById(R.id.tv_showBMI);
        bmi_calculate = (Button)findViewById(R.id.bmi_calculate);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        init();
        bmi_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kgStr = et_kg.getText().toString();
                String cmStr = et_cm.getText().toString();
                if(kgStr.equals("") || cmStr.equals("")){
                    Toast.makeText(BMIActivity.this,"请输入身高、体重",Toast.LENGTH_SHORT).show();
                }
                else {
                    double kg = Double.parseDouble(kgStr);
                    double m = Double.parseDouble(cmStr)/100;
                    double bmi = (kg/(m*m));
                    if(bmi<18.5){
                        show_bmi.setText("BMI值为："+bmi+"  偏瘦");
                    } else if((bmi>=18.5)&&(bmi<25)){
                        show_bmi.setText("BMI值为："+bmi+"  正常");
                    } else if((bmi>=25)&&(bmi<28)){
                        show_bmi.setText("BMI值为："+bmi+"  超重");
                    } else if((bmi>=28)&&(bmi<32)){
                        show_bmi.setText("BMI值为："+bmi+"  肥胖");
                    } else if(bmi>32){
                        show_bmi.setText("BMI值为："+bmi+"  非常肥胖");
                    } else {
                        show_bmi.setText("无法计算");
                    }
                }

            }
        });
    }
}
