package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Button btnTamanna, btnFaz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnFaz = findViewById(R.id.btnFaz);
        btnTamanna = findViewById(R.id.btnTamanna);

        // Onclick of Faz button
        btnFaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FazFragment());
            }
        });

        // Onclick of Tamannah button
        btnTamanna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new TamannaFragment());
            }
        });

    }

    // Function to load fragment into FrameLayout
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.myFrameLayout,fragment);
        fragmentTransaction.commit();
    }
}


