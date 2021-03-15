package com.example.ht08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    SeekBar simpleSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        simpleSeekBar=(SeekBar)findViewById(R.id.seekBar2);



    }

    BottleDispenser BD = BottleDispenser.getInstance();


    public void addMoney(View v) {

        BD.addMoney(text,simpleSeekBar.getProgress());
    }

    public void buyBottle(View v){
        BD.buyBottle(1,text);

    }
    public void returnMoney(View v){
        BD.returnMoney(text);
    }

}