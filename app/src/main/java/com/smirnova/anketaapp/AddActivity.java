package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.MainActivity.anketa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
            else{
                    etName.setText(anketa.getUserName());
                    etLastName.setText(anketa.getLastName());
                    etPhone.setText(anketa.getPhone());
                    etSite.setText(anketa.getSite());
                    etAdress.setText(anketa.getAdress());
            }

        }

    }
    public void BtnSaveClick(View v){

        anketa.setUserName(etName.getText().toString());
        anketa.setLastName(etLastName.getText().toString());
        anketa.setPhone(etPhone.getText().toString());
        anketa.setSite(etSite.getText().toString());
        anketa.setAdress(etAdress.getText().toString());
//        Intent intent = new Intent();
        setResult(RESULT_OK);
        finish();

    }
    public void  BtnActionClick (View v){
        Intent intent;
        switch (v.getId()) {
            case R.id.btnSite:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+ anketa.getSite()));
                startActivity(intent);
                break;
            case R.id.btnAdress:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+ anketa.getAdress()));
                startActivity(intent);
                break;
            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+anketa.getPhone()));
                startActivity(intent);
                break;
        }


    }
}