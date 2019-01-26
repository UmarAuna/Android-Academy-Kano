package com.httpurlcon.simpleandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven,
    eight, nine, zero, mult, div, add, sub, equal, point, clear;
    EditText Display;
    double num1, num2;
    boolean Addition, Subtraction, Multiplication, Division;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.divide);
        add = findViewById(R.id.addition);
        sub = findViewById(R.id.minus);
        equal = findViewById(R.id.equal);
        point = findViewById(R.id.point);
        clear = findViewById(R.id.clear);
        Display = findViewById(R.id.display);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + "0");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + ".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText(Display.getText() + " ");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Display == null){
                    Display.setText("");
                }else{
                    num1 = Double.parseDouble(Display.getText() + "");
                    Addition = true;
                    Display.setText(null);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(Display.getText() + "");
                Subtraction = true;
                Display.setText(null);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(Display.getText() + "");
                Multiplication = true;
                Display.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(Display.getText() + "");
                Division = true;
                Display.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(Display.getText() + "");

                if( Addition ==  true){
                    Display.setText(num1 + num2 + "");
                }else if(Subtraction == true){
                    Display.setText(num1 - num2 + "" );
                }else if(Multiplication == true){
                    Display.setText(num1 * num2 + "");
                }else if(Division == true){
                    Display.setText(num1 / num2 + "");
                }
            }
        });


    }
}
