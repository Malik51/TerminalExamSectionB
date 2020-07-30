package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {
public RecyclerView recycle;
Mid_term_Adaptor adaptor;
DatabaseHelper db;
ArrayList<Mditerm1> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        db=new DatabaseHelper(this);
        recycle=(RecyclerView) findViewById(R.id.recycle1);
        list=new ArrayList<>();
        list=db.getAll();
        adaptor = new Mid_term_Adaptor(this, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(mLayoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());
        //recycle.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recycle.setAdapter(adaptor);
    }
}