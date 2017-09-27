package com.demo.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;


public class Rhyme extends AppCompatActivity {

    ToggleButton tb =(ToggleButton) findViewById(R.id.tb);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhyme);
        tb.setTextOn("ONNNN");

        tb.setTextOff("Offfff");

    }


    public void old(View view) {

    }
}
