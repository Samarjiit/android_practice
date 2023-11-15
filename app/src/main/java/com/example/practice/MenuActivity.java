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

/*



package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn=(Button)findViewById(R.id.button);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()) {
            case "Toast":
                String col = btn.getText().toString();
                Toast.makeText(this, "Color is" + col, Toast.LENGTH_SHORT).show();
                return true;

            case "Red":
                btn.setBackgroundColor(getResources().getColor(R.color.red));
                btn.setTextColor(getResources().getColor(R.color.black));
                btn.setText("Red");
                return true;

            case "Blue":
                btn.setBackgroundColor(getResources().getColor(R.color.blue));
                btn.setTextColor(getResources().getColor(R.color.black));
                btn.setText("Blue");
                return true;


            case "Exit":
                MainActivity.this.finish();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item); //t calls the parent's class method so it has a chance to run what it needs to run. If you were to use something like this.onOptionsItemSelected(item); then it would be a infinite loop.


        }


    }
}






 */