package com.example.vachetaureau;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Consultebase extends AppCompatActivity {

    DatabaseHelper db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultebase);
        ListView liste=(ListView)findViewById(R.id.liste);
        db = new DatabaseHelper(this);
        Cursor data = db.getData();
        ArrayList<String> liste1 =new ArrayList<>() ;
        while (data.moveToNext()){
            liste1.add(data.getString(1));
            liste1.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,liste1);
        liste.setAdapter(adapter);
    }



}
