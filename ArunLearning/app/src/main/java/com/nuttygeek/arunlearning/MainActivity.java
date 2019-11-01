package com.nuttygeek.arunlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ProgressBar progressBar;
    RadioGroup radioGroup;
    CheckBox checkBox;
    Switch switch1;
    EditText editText;
    SeekBar seekBar;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init views
        progressBar = findViewById(R.id.loading);
        button1 = findViewById(R.id.button1);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkbox);
        switch1 = findViewById(R.id.switch1);
        editText = findViewById(R.id.edit);
        seekBar = findViewById(R.id.seekbar);
        spinner = findViewById(R.id.spinner);

        // get intent value
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        Toast.makeText(this, "name: "+name, Toast.LENGTH_SHORT).show();

        final String[] values = {"Ankur", "Arun", "Mohit", "Rohit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, values);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = values[i];
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "val: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(), "Switch: ON", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Switch: OFF", Toast.LENGTH_LONG).show();
                }
            }
        });

        boolean val = checkBox.isChecked();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(), "Checkbox Checked", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Checkbox unChecked", Toast.LENGTH_LONG).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(id);
                String str = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressBar.setVisibility(View.GONE);
//            }
//        });

        Log.v("arun", "On Create");
    }



    public void handleClicks(View v){
        if(v.getId()==R.id.button1){
            Toast.makeText(this, "Button Clicked !", Toast.LENGTH_SHORT).show();
            String textVal = editText.getText().toString();
            Toast.makeText(this, textVal, Toast.LENGTH_SHORT).show();
        }
    }

}
