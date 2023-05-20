package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class PrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String text = pref.getString("pref", "");
        TextView view = findViewById(R.id.textViewPref);
        view.setText("cdsdccd");
    }
}