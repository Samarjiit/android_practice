package com.example.practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView tvUser;
    Button btnSpinner, btnListView, btnFragment, btnMenu, btnSettings, btnRefresh, btnDatabase;
    FloatingActionButton fabAdd;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPrefManager = new SharedPrefManager(MainActivity.this);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnListView = findViewById(R.id.btnListView);
        btnFragment = findViewById(R.id.btnFragment);
        btnMenu = findViewById(R.id.btnMenu);
        btnSettings = findViewById(R.id.btnSettings);
        btnRefresh = findViewById(R.id.btnRefresh);
        fabAdd = findViewById(R.id.fabAdd);
        btnDatabase = findViewById(R.id.btnDatabase);
        tvUser = findViewById(R.id.tvUser);

        tvUser.setText("User : "+sharedPrefManager.getUser());

        // Notifiation code
        // Creating channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("myChannelID","myChannelName",NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("myDesc");
            NotificationManager notificationManager= getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        // Building notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myChannelID")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("MyContentTitle")
                .setContentText("MyContentText")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);


        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
                // Sending Notification
                notificationManagerCompat.notify(100,builder.build());

                // AlertDialog
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setMessage("Close this alert?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "huh?", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("myTitle");
                alert.show();
            }
        });

        btnSpinner.setOnClickListener(view -> {
            Intent spinnerActivity = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(spinnerActivity);
        });

        btnListView.setOnClickListener(view -> {
            Intent listViewActivity = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(listViewActivity);
        });

        btnFragment.setOnClickListener(view -> {
            Intent listViewActivity = new Intent(MainActivity.this, FragmentActivity.class);
            startActivity(listViewActivity);
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuViewActivity = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(menuViewActivity);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingActivity);
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent databaseActivity = new Intent(MainActivity.this, ContactPageActivity.class);
                startActivity(databaseActivity);
            }
        });
    }

//    @Override
//    protected  void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this, "App onDestroy toast", Toast.LENGTH_SHORT).show();
//        Log.d("UFF","onDestroy");
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "App onStop toast", Toast.LENGTH_SHORT).show();
//        Log.d("UFF","onStop");
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "App onResume toast", Toast.LENGTH_SHORT).show();
//        Log.d("UFF","onResume");
//    }
}