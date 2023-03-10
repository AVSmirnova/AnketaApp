package com.smirnova.anketaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnShow;
    Boolean showButtonPressed =false;

    public static Anketa anketa= new Anketa();

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
        if  (v.getId()==R.id.btnShow) {
            showButtonPressed = true;
        }

        intent=new Intent(this,AddActivity.class);
        intent.putExtra("SHOW", showButtonPressed);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){

            btnShow.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.INVISIBLE);
        }

    }
}