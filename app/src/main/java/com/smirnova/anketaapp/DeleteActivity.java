package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.ListActivity.listFam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    ListView listViewDelete;
    ArrayAdapter<String> adapter;
    ArrayList<Integer> deleteList = new ArrayList<Integer>() ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setTitle("Удаление"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewDelete = findViewById(R.id.listViewDelete);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listFam);
        listViewDelete.setAdapter( adapter);
        listViewDelete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listViewDelete.isItemChecked(i)){
                    deleteList.add(i);
                }
                if(!listViewDelete.isItemChecked(i)){
                   int index= deleteList.indexOf(i);
                    deleteList.remove(index);
                }
                Log.d("tag",String.valueOf(deleteList.size()));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_delete_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

         switch (item.getItemId()){
            case R.id.home:
                finish();
                break;
            case R.id.optionDelete:
                Intent intent = new Intent();
                intent.putExtra("DELETE",deleteList );
                setResult(RESULT_CANCELED,intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}