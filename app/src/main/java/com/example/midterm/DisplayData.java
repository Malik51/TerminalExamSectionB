package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {
public TextView txt1;
    public TextView txt2;
    public TextView txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
    txt1=(TextView) findViewById(R.id.display1);
        txt2=(TextView) findViewById(R.id.display2);
        txt3=(TextView) findViewById(R.id.display3);
           Bundle b=getIntent().getExtras();
           Mditerm1 m=(Mditerm1) b.getSerializable("details");
           txt1.setText(m.title);
           txt2.setText(m.Task_detail);
           txt3.setText(m.date);
    }
}