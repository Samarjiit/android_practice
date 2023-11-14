package com.example.practice;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // KEY NAMES
    String KEY_USER = "user";
    String KEY_PASS = "pass";

    public SharedPrefManager(Context context){
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
    }

    // Username variable
    public void setUser(String user){
        editor.putString(KEY_USER, user);
        editor.commit();
    }
    public String getUser(){
        return sharedPreferences.getString(KEY_USER,"NOT_SET");
    }

    // Password variable
    public void setPass(String pass){
        editor.putString(KEY_PASS, pass);
        editor.commit();
    }
    public String getPass(){
        return sharedPreferences.getString(KEY_PASS,"NOT_SET");
    }




}
