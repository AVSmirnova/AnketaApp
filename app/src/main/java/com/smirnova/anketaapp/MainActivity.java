package com.smirnova.anketaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnShow;
    Boolean showButtonPressed =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow =findViewById(R.id.btnShow);
        btnAdd = findViewById(R.id.btnAdd);


       if(!showButtonPressed){
           btnShow.setVisibility(View.INVISIBLE);
       }
       else{
           btnShow.setVisibility(View.VISIBLE);
       }

    }
    public void BtnClick(View v){
        Intent intent;
        if  (v.getId()==R.id.btnAdd) {
            intent=new Intent(this,AddActivity.class);
            startActivityForResult(intent,1);
        }
        else {
            intent=new Intent(this,AddActivity.class);
            showButtonPressed = true;
            intent.putExtra("SHOW", showButtonPressed);
            startActivity(intent);
        }


    }
}