package com.example.ht08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);


    }

    BottleDispenser BD = BottleDispenser.getInstance();


    public void addMoney(View v) {

        BD.addMoney(text);
    }

    public void buyBottle(View v){
        BD.buyBottle(1,text);

    }
    public void returnMoney(View v){
        BD.returnMoney(text);
    }

}