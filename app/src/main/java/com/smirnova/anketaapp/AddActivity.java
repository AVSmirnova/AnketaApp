package com.smirnova.anketaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etName;
    EditText etLastName;
    EditText etPhone;
    Button btnPhone;
    EditText etSite;
    Button btnSite;
    EditText etAdress;
    Button btnAdress;
    Button btnSave;

    Boolean saveStatus =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName=findViewById(R.id.etName);
        etLastName=findViewById(R.id.etLastName);
        etPhone=findViewById(R.id.etPhone);
        btnPhone=findViewById(R.id.btnPhone);
        etSite=findViewById(R.id.etSite);
        btnSite=findViewById(R.id.btnSite);
        etAdress =findViewById(R.id.etAdress);
        btnAdress=findViewById(R.id.btnAdress);
        btnSave=findViewById(R.id.btnSave);


        Bundle arguments=getIntent().getExtras();
        if(arguments!=null){
            Boolean choose = arguments.getBoolean("SHOW");
            if (!choose) {
                btnPhone.setVisibility(View.INVISIBLE);
                btnSite.setVisibility(View.INVISIBLE);
                btnAdress.setVisibility(View.INVISIBLE);
            }

        }

    }
    public void BtnSaveClick(View v){


        Intent intent = new Intent();
        setResult(RESULT_OK);
        finish();

    }
}