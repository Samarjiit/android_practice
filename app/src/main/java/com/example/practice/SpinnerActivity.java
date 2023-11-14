package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Initialize Spinner
        mySpinner = findViewById(R.id.mySpinner);

        // Generate data to be shown
        ArrayList<String> myData = new ArrayList<>();
        myData.add("");
        myData.add("Hello1");
        myData.add("Hello2");
        myData.add("Hello3");
        myData.add("Hello4");

        // Make arrayAdapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myData);

        // Set the adapter to Spinner
        mySpinner.setAdapter(myAdapter);

        // Set onClick event function
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    // Custom Toast: FIRST, NEED TO MAKE CUSTOM_TOAST_LAYOUT FILE
                    // Inflate Custom Layout into the View, so that you can alter data later
                    LayoutInflater inflater = getLayoutInflater();
                    View v = inflater.inflate(R.layout.my_custom_toast, findViewById(R.id.mainToastLayout));

                    // Change Text in Custom Toast
                    TextView myToastText =v.findViewById(R.id.myText);
                    myToastText.setText(myData.get(i)); // Load Array data using variable "i"

                    // Make Toast object, set duration, view and show it
                    Toast customToast = new Toast(SpinnerActivity.this);
                    customToast.setDuration(Toast.LENGTH_SHORT);
                    customToast.setView(v);
                    customToast.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}