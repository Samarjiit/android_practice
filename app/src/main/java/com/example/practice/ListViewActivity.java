package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ToggleButton myToggleBtn;
    ListView myListView;
    TextView myListText;
    EditText myEditText;
    Button btnAdd, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myToggleBtn = findViewById(R.id.myToggleBtn);
        myListView = findViewById(R.id.myListView);
        myListText = findViewById(R.id.myListText);
        myEditText = findViewById(R.id.myEditText);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);

        // Data for ListView
        ArrayList<String> myData = new ArrayList<>();
        myData.add("Nikhil");
        myData.add("No");
        myData.add("Ass");
        myData.add("I think, he forgot");

        // Adapter for ListView
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(ListViewActivity.this, android.R.layout.simple_list_item_1, myData);
        myListView.setAdapter(myAdapter);

        // Change TextView, onClick of ListItems
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myListText.setText(myData.get(i));
            }
        });

        // ToggleButton functionality
        myToggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if button is ON or OFF
                if(!myToggleBtn.isChecked()){
                    myListText.setVisibility(View.VISIBLE);
                } else {
                    myListText.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Add Button Functionality
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myData.contains(myEditText.getText().toString().trim())){
                    Toast.makeText(ListViewActivity.this, "Item already present", Toast.LENGTH_SHORT).show();
                }else{
                    if(!myEditText.getText().toString().equals("")){
                        myData.add(myEditText.getText().toString().trim());
                        myAdapter.notifyDataSetChanged();               //Refresh adapter after data is added
                        myEditText.setText("");
                    }
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myData.contains(myEditText.getText().toString().trim())){
                    myData.remove(myEditText.getText().toString());
                    myAdapter.notifyDataSetChanged();
                    myEditText.setText("");
                }else{
                    btnAdd.performClick();
                }
            }
        });

    }
}