package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    Button btnUpdate;
    TextView tvName, tvPass;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPrefManager = new SharedPrefManager(SettingsActivity.this);

        btnUpdate = findViewById(R.id.btnUpdate);
        tvName = findViewById(R.id.tvName);
        tvPass = findViewById(R.id.tvPass);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManager.setUser(tvName.getText().toString());
                sharedPrefManager.setPass(tvPass.getText().toString());
                Toast.makeText(SettingsActivity.this, "User data updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}