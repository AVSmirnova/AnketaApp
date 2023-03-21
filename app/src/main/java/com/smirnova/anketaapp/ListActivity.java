package com.smirnova.anketaapp;

import static com.smirnova.anketaapp.MainActivity.profiles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener{

    public static final int ADD_VIEW=1;
    public static final int DEL_VIEW=2;

    ListView listViewAnketa;
    TextView textViewHeader;
    ArrayAdapter<String> adapter;
    Anketa newAnketa;
    public static ArrayList<String> listFam;
    int position=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

       /* getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

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
        initData();
       /* profiles.add(new Anketa("Андрей","Петров","","",""));
        listFam.add(profiles.get(0).lastName);
        profiles.add(new Anketa("Максим","Иванов","","",""));
        listFam.add(profiles.get(1).lastName);
        profiles.add(new Anketa("Никита","Сидоров","","",""));
        listFam.add(profiles.get(2).lastName);
        profiles.add(new Anketa("Петр","Кузнецов","","",""));
        listFam.add(profiles.get(3).lastName);
        profiles.add(new Anketa("Евгений","Васильев","","",""));
        listFam.add(profiles.get(4).lastName);
        profiles.add(new Anketa("","Румянцев","","",""));
        listFam.add(profiles.get(5).lastName);*/

        if (!profiles.isEmpty()){
            textViewHeader.setText(getResources().getString(R.string.spisok));
        }
        listViewAnketa.setTextFilterEnabled(true);

        registerForContextMenu(listViewAnketa);



    }
    private void initData(){

        profiles.add(new Anketa("Андрей","Петров","","",""));
        profiles.add(new Anketa("Максим","Иванов","","",""));
        profiles.add(new Anketa("Никита","Сидоров","","",""));
        profiles.add(new Anketa("Петр","Кузнецов","","",""));
        profiles.add(new Anketa("Евгений","Vasilev","","",""));
        profiles.add(new Anketa("","Rumyancev","","",""));
        for (Anketa user:profiles
             ) {
            ;
            listFam.add(setNameLetter(user));
        }

    }
    private String setNameLetter(Anketa user){
        String fio="";
        if(user.getUserName()!="" && user.getUserName().length()!=0){
            fio=user.getLastName()+" "+user.getUserName().charAt(0)+".";
        }
        else{
            fio=user.getLastName();
        }
        return  fio;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_add_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        setupSearchView(searchView);


        return super.onCreateOptionsMenu(menu);
    }
    private void setupSearchView(SearchView mSearchView) {
        Log.d("tagg","true");
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setQueryHint("Search Sender");
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        int id = item.getItemId();
        switch (id) {
            case R.id.optionDelete:
                profiles.remove(position);
                listFam.remove(position);
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            if(requestCode==ADD_VIEW){
            newAnketa = data.getParcelableExtra(Anketa.class.getSimpleName());
            if (resultCode==RESULT_OK) {

                profiles.add(newAnketa);
                listFam.add(setNameLetter(newAnketa));
                textViewHeader.setText(getResources().getString(R.string.spisok));
            }
            if (resultCode==RESULT_CANCELED){
               profiles.set(position,newAnketa);
               listFam.set(position,setNameLetter(newAnketa));

            }
            }
            if(requestCode==DEL_VIEW){
                ArrayList<Integer> deleteList = data.getIntegerArrayListExtra("DELETE") ;
                if (deleteList!=null) {
                    Collections.sort(deleteList);
                    Collections.reverse(deleteList);
                    for (int position : deleteList
                    ) {
                        Log.d("tag",String.valueOf(position));
                        profiles.remove(position);
                        listFam.remove(position);

                    }
                }
                else{
                    Log.d("tag","null");
                }

                adapter.notifyDataSetChanged();
            }
            else  Log.d("tag","datanull");



        }


    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ArrayList<String> filtrFam= new ArrayList<String>();


            for (String fam : listFam
            ) {
                if (fam.toLowerCase().contains(newText.toLowerCase())) {
                    filtrFam.add(fam);
                }

            }

        ArrayAdapter<String> adapter =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, filtrFam);
        listViewAnketa.setAdapter(adapter);

        return false;
    }
}