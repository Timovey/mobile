package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        Button buttonOpenPref = (Button) findViewById(R.id.button3);

        Button buttonDb = (Button) findViewById(R.id.button_db);

        Button buttonOpenFragment = (Button) findViewById(R.id.buttonOpenFragment);
        EditText input = (EditText) findViewById(R.id.editTextText);
        button.setOnClickListener(v -> {
            String h = getResources().getString(R.string.text);
            Toast.makeText(this, h, Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, DetailActivity.class);
//            Intent i = new Intent(getActivity(), DetailActivity.class);
            i.putExtra("log", "sdcdscsdcsc");
            startActivity(i);
        });

        Button buttonSave = (Button) findViewById(R.id.button5);
        buttonSave.setOnClickListener(v -> {
            String text = input.getText().toString();
            SharedPreferences pref =  getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = pref.edit();
            ed.putString("pref", text);
            ed.commit();
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        });
        buttonOpenPref.setOnClickListener(v -> {
            Intent i = new Intent(this, PrefActivity.class);
            startActivity(i);
        });

        buttonOpenFragment.setOnClickListener(v -> {
            Intent i = new Intent(this, FragmentActivity.class);
            startActivity(i);
        });

        buttonDb.setOnClickListener(v -> {
            Intent i = new Intent(this, DbActivity.class);
            startActivity(i);
        });

    }
}