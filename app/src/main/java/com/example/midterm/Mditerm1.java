package com.example.midterm;

import java.io.Serializable;

public class Mditerm1 implements Serializable {
    public String title;
    public String Task_detail;
    public String date;
    Mditerm1(){

    }
    public Mditerm1(String t,String d,String da)
    {
        title=t;
        Task_detail=d;
        date=da;
    }
}
