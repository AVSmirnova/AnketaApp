package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.ListActivity.listFam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        getSupportActionBar().setTitle("Удаление"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewDelete = findViewById(R.id.listViewDelete);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listFam);
        listViewDelete.setAdapter( adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_delete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;


        }



        return super.onOptionsItemSelected(item);
    }
}