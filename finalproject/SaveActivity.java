package com.example.project.finalproject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {

    String mylat="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String LAT = "lat";
    SharedPreferences sharedpreferences;
    TextView ll;
    CustomShared customShared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);


        customShared = new CustomShared(getApplicationContext());

        ll = (TextView)findViewById(R.id.lat);

            ll.setText(customShared.getlat());


    }
}
