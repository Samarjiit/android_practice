package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import android.os.Bundle;
import android.view.Menu;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    // To add menu to activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Get menu from menu folder. MENU FILE SHOULD BE CREATED FIRST
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
}