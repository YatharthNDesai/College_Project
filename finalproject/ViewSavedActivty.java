package com.example.project.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSavedActivty extends AppCompatActivity {

    TextView textView;
    CustomShared customShared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved_activty);

        textView = (TextView)findViewById(R.id.savedlat);
        customShared = new CustomShared(getApplicationContext());


        textView.setText(customShared.getlat());
    }
}
