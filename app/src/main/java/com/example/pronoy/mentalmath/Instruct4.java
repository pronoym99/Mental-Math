package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instruct4 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct4);
    }

    public void goto_play4_start(View v)
    {
        Intent int_play4_start=new Intent();
        int_play4_start.setClass(this,StartActivity.class);
        startActivity(int_play4_start);
        finish();
    }

    /* UNDER DEVELOPMENT */
}
