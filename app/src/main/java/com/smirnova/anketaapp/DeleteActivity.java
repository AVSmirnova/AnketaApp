package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.ListActivity.listFam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DeleteActivity extends AppCompatActivity {

    ListView listViewDelete;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setTitle("Your Activity Title"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewDelete = findViewById(R.id.listViewDelete);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listFam);
        listViewDelete.setAdapter( adapter);



    }
}