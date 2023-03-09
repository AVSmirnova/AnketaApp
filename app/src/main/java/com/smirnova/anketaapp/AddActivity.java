package com.smirnova.anketaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Bundle arguments=getIntent().getExtras();
        if(arguments!=null){

        }

    }
}