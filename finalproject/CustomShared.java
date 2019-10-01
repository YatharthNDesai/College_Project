package com.example.project.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

//import android.content.SharedPreferences;

/**
 * Created by Kanu on 10/15/2016.
 */

public class CustomShared {

    public static final String PREFS_NAME = "MYPREF";
    private final Context context;
    private final SharedPreferences sharedPrefs;

    public static final String LAT = "lat";

    public CustomShared(Context context) {
        this.context = context;
        sharedPrefs = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public void saveslate(String text) {
        SharedPreferences.Editor editor;
        editor = sharedPrefs.edit(); //2
        editor.putString(LAT, text); //3
        Log.d("sharedpred",text+"");
        editor.apply(); //4
    }
    public String getlat() {
        String text;
        text = sharedPrefs.getString(LAT, "");
        Log.d("sharedpree",text+"");
        return text;
    }


}
