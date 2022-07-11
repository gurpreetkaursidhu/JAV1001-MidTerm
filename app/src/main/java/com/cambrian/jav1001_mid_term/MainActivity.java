package com.cambrian.jav1001_mid_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // creating array for the spinner
    String[] items = {"miles to km","km to miles", "c to f" , "f to c", "c to k", "f to k", "in to cm", "lb to kg", "kg to lb","oz to gram", "gram to oz","cups to liter", "liter to cups", "cm to in"};
    String currentConversion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner converterSpinner = (Spinner) findViewById(R.id.converterSpinner);
        EditText inputText = (EditText) findViewById(R.id.inputText);
        EditText outputText = (EditText) findViewById(R.id.outputText);
        Button convertButton = (Button) findViewById(R.id.convertButton);

        converterSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        converterSpinner.setAdapter(adapter);
        converterSpinner.setOnItemSelectedListener(this);

        convertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (inputText.getText().toString().isEmpty()) {
                    outputText.setText("");
                }
                else if (currentConversion.equals("km to miles")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText())) * 0.62));
                }
                else if (currentConversion.equals("miles to km")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 1.60934));
                }
                else if (currentConversion.equals("c to f")) {
                    Double tempValue = Double.parseDouble(String.valueOf(inputText.getText()));
                    outputText.setText(String.valueOf((tempValue * 1.8) + 32));
                }
                else if (currentConversion.equals("f to c")) {
                    Double tempValue = Double.parseDouble(String.valueOf(inputText.getText()));
                    outputText.setText(String.valueOf((tempValue - 32) * 5/9));
                }
                else if (currentConversion.equals("c to k")) {
                    Double tempValue = Double.parseDouble(String.valueOf(inputText.getText()));
                    outputText.setText(String.valueOf(tempValue + 273.15));
                }
                else if (currentConversion.equals("f to k")) {
                    Double tempValue = Double.parseDouble(String.valueOf(inputText.getText()));
                    outputText.setText(String.valueOf((tempValue - 32)* 5/9 +273.15));
                }
                else if (currentConversion.equals("kg to lb")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 2.2));
                }
                else if (currentConversion.equals("lb to kg")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 0.45));
                }
                else if (currentConversion.equals("gram to oz")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 0.04));
                }
                else if (currentConversion.equals("oz to gram")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 28.35));
                }
                else if (currentConversion.equals("liter to cups")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText()))  * 4.17));
                }
                else if (currentConversion.equals("cups to liter")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText())) * 0.24));
                }
                else if (currentConversion.equals("in to cm")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText())) * 2.54));
                }
                else if (currentConversion.equals("cm to in")) {
                    outputText.setText(String.valueOf(Double.parseDouble(String.valueOf(inputText.getText())) / 2.54));
                }
                else {
                    outputText.setText("");
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        currentConversion = items[position];
        EditText inputText = (EditText) findViewById(R.id.inputText);
        EditText outputText = (EditText) findViewById(R.id.outputText);
        inputText.setText("");
        outputText.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}