package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        BlankFragment frag = new BlankFragment();
        FragmentTransaction fragTrans = getFragmentManager().beginTransaction();
        getSupportFragmentManager().
                beginTransaction().
                setReorderingAllowed(true).
                add(R.id.frame_layout, BlankFragment.class,null).
                commit();
//        TextView input = findViewById(R.id.textViewz_fragment);
//        input.setText("dcsdssccdsc");
    }
}