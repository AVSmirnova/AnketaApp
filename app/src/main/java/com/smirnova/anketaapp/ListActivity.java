package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.MainActivity.profiles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public static final int ADD_VIEW=1;
    public static final int DEL_VIEW=2;

    ListView listViewAnketa;
    TextView textViewHeader;
    ArrayAdapter<String> adapter;
    public static ArrayList<String> listFam;
    int position=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listViewAnketa=findViewById(R.id.listViewAnketa);
        textViewHeader = findViewById(R.id.textViewHeader);
        listFam=new ArrayList<String>();

        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listFam);

        listViewAnketa.setAdapter(adapter);
        listViewAnketa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                intent.putExtra("ADD",false);
                intent.putExtra(Anketa.class.getSimpleName(),profiles.get(i));
                startActivityForResult(intent,ADD_VIEW );
            }
        });


        if (!profiles.isEmpty()){
        textViewHeader.setText(getResources().getString(R.string.spisok));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_add_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent  intent;
        switch (item.getItemId()){
            case R.id.optionAdd:
              intent=new Intent(this,AddActivity.class);
              intent.putExtra("ADD", true );
              startActivityForResult(intent,ADD_VIEW );
              break;
            case R.id.optionalDel:
               intent=new Intent(this,DeleteActivity.class);

                startActivityForResult(intent,DEL_VIEW );
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    Anketa newAnketa;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            newAnketa = data.getParcelableExtra(Anketa.class.getSimpleName());
            if (resultCode==RESULT_OK) {
                profiles.add(newAnketa);
                listFam.add(newAnketa.getLastName());

                textViewHeader.setText(getResources().getString(R.string.spisok));
            }
            if (resultCode==RESULT_CANCELED){
               profiles.set(position,newAnketa);
               listFam.set(position,newAnketa.getLastName());

            }

             adapter.notifyDataSetChanged();
        }


    }



}