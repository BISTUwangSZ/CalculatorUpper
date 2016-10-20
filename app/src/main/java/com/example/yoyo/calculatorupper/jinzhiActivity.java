package com.example.yoyo.calculatorupper;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class jinzhiActivity extends AppCompatActivity implements View.OnClickListener{
    Button one,two,three,four,five,six,seven,eight,nine,zero,a,b,c,d,e,f,ce_jinzhi;
    String equation="";
    EditText result_jinzhi;
    String oldRadix = "",radix_result="";
    public void init(){
        result_jinzhi = (EditText)findViewById(R.id.result_jinzhi);
        ce_jinzhi = (Button) findViewById(R.id.ce_jinzhi) ;
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        a = (Button)findViewById(R.id.a);
        b = (Button)findViewById(R.id.b);
        c = (Button)findViewById(R.id.c);
        d = (Button)findViewById(R.id.d);
        e = (Button)findViewById(R.id.e);
        f = (Button)findViewById(R.id.f);

        this.one.setOnClickListener(this);
        this.two.setOnClickListener(this);
        this.three.setOnClickListener(this);
        this.four.setOnClickListener(this);
        this.five.setOnClickListener(this);
        this.six.setOnClickListener(this);
        this.seven.setOnClickListener(this);
        this.eight.setOnClickListener(this);
        this.nine.setOnClickListener(this);
        this.zero.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.ce_jinzhi.setOnClickListener(this);

        }

    //禁用2-7
    public void forbidFromTwo(){
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
    }
    //放开2-7
    public void freeFromtwo(){
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
    }
    //禁用8,9
    public void forbidFromEight(){
        eight.setEnabled(false);
        nine.setEnabled(false);
    }
    //放开8,9
    public void freeFromEight(){
        eight.setEnabled(true);
        nine.setEnabled(true);
    }
    //禁用a-f
    public void forbidFromA(){
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
    }
    //放开a-f
    public void freeFromA(){
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
    }
    //十进制转换为二进制
    public String DtoB(){
        String text;
        text= Integer.toBinaryString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }
    //十进制转换为八进制
    public String DtoO(){
        String text;
        text= Integer.toOctalString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }
    //十进制转换为十六进制
    public String DtoH(){
        String text;
        text= Integer.toHexString(Integer.parseInt(result_jinzhi.getText().toString()));
        return text;
    }
    //十六进制转十进制
    public String HtoD(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        return String.valueOf(text);
    }
   //八进制转十进制
   public String OtoD(){
       int text;
       text = Integer.valueOf(result_jinzhi.getText().toString(),8);
       return String.valueOf(text);
   }
    //二进制转十进制
    public String BtoD(){
        int text;
        text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        return String.valueOf(text);
    }
    //二进制转换为八进制
    public String BtoO(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        String number = Integer.toOctalString(text);
        return number;
    }
    //八进制转换为二进制
    public String OtoB(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),8);
        String number = Integer.toBinaryString(text);
        return number;
    }
    //二进制转十六进制
    public String BtoH(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),2);
        String number = Integer.toHexString(text);
        return number;
    }
    //十六进制转换为二进制
    public String HtoB(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        String number = Integer.toBinaryString(text);
        return number;
    }
    //八进制转换为十六进制
    public String OtoH(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),8);
        String number = Integer.toHexString(text);
        return number;
    }
    //十六进制转换为八进制
    public String HtoO(){
        int text = Integer.valueOf(result_jinzhi.getText().toString(),16);
        String number = Integer.toOctalString(text);
        return number;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
        init();
    }
    public void checkRadix(View v){
        boolean checked = ((RadioButton)v).isChecked();
        switch (v.getId()){
            //二进制
            case R.id.binaryradix:
                if(checked){
                    forbidFromTwo();
                    forbidFromEight();
                    forbidFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoB();
                        result_jinzhi.setText(radix_result);
                    } else  if(oldRadix.equals("O")) {
                        radix_result = OtoB();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("H")){
                        radix_result = HtoB();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "B";
            }break;
            //八进制
            case R.id.octonary:
                if(checked){
                    freeFromtwo();
                    forbidFromEight();
                    forbidFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoO();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("B")){
                        radix_result = BtoO();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("H")){
                        radix_result = HtoO();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "O";
                }break;
            //十进制
            case R.id.decimal:
                if(checked){
                    freeFromtwo();
                    freeFromEight();
                    forbidFromA();
                    if(oldRadix.equals("H")){
                        radix_result=HtoD();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("O")){
                        radix_result = OtoD();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("B")){
                        radix_result = BtoD();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix = "D";
            }break;
            //十六进制
            case R.id.hex:
                if(checked){
                    freeFromtwo();
                    freeFromEight();
                    freeFromA();
                    if(oldRadix.equals("D")){
                        radix_result = DtoH();
                        result_jinzhi.setText(radix_result);
                    }else if(oldRadix.equals("B")) {
                        radix_result = BtoH();
                        result_jinzhi.setText(radix_result);
                    } else if(oldRadix.equals("O")){
                        radix_result = OtoH();
                        result_jinzhi.setText(radix_result);
                    }
                    oldRadix="H";
                }break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == one.getId()) {
            // 数1
            this.equation += "1";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.two) {
            // 数2
            this.equation += "2";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.three) {
            // 数3
            this.equation += "3";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.four) {
            // 数4
            this.equation += "4";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.five) {
            // 数5
            this.equation += "5";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.six) {
            // 数6
            this.equation += "6";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.seven) {
            // 数7
            this.equation += "7";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.eight) {
            // 数8
            this.equation += "8";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.nine) {
            // 数9
            this.equation += "9";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.zero) {
            // 零
            this.equation += "0";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.a) {
            // A
            this.equation += "A";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.b) {
            // B
            this.equation += "B";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.c) {
            // C
            this.equation += "C";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.d) {
            // D
            this.equation += "D";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.e) {
            // E
            this.equation += "E";
            this.result_jinzhi.setText(this.equation);
        } else if (v == this.f) {
            // F
            this.equation += "F";
            this.result_jinzhi.setText(this.equation);
        }else if (v == this.ce_jinzhi) {
            //清空
            this.equation="";
            this.result_jinzhi.setText("0");
        }
    }
}
