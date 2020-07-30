package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Edt1;
    EditText Edt2;
    EditText Edt3;
    Button Submit1;
    Button Next1;
    DatabaseHelper db;
    List<Mditerm1> task1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        task1=new ArrayList<Mditerm1>();
        Edt1=(EditText) findViewById(R.id.txt1);
        Edt2=(EditText) findViewById(R.id.txt2);
        Edt3=(EditText) findViewById(R.id.txt3);
        Submit1=(Button) findViewById(R.id.btn1);
        Next1=(Button) findViewById(R.id.btn2);
        Submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mditerm1 task2=new Mditerm1(Edt1.getText().toString(),Edt2.getText().toString(),Edt3.getText().toString());
            db.insert(task2);
                Toast.makeText(getApplicationContext(),"successFully added",Toast.LENGTH_LONG).show();
               Edt1.setText("");
                Edt2.setText("");
                Edt3.setText("");

            }

        });
        Next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ShowList.class);
                startActivity(intent);
            }
        });

    }
}