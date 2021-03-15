package com.example.ht08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    SeekBar simpleSeekBar;
    Spinner spinner1;
    Spinner spinner2 ;
    String spinnerListBottle[] = {"Pepsi","Pepsi Max", "Coca-Cola", "Coca-Cola Zero", "Fanta", "Fanta Zero"};
    Double spinnerListSize[] = {0.5,1.5};
    String bottle;
    Double size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        simpleSeekBar=(SeekBar)findViewById(R.id.seekBar2);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1,spinnerListBottle);
        ArrayAdapter<Double> adapter2 = new ArrayAdapter<Double>(MainActivity.this , android.R.layout.simple_list_item_1,spinnerListSize);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bottle = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        }

        );
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size = Double.parseDouble(parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    BottleDispenser BD = BottleDispenser.getInstance();



    public void addMoney(View v) {

        BD.addMoney(text,simpleSeekBar.getProgress());
    }

    public void buyBottle(View v){
        BD.buyBottle(text,bottle,size);

    }
    public void returnMoney(View v){
        BD.returnMoney(text);
    }

}