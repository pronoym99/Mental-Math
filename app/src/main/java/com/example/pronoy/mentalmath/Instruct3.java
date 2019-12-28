package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instruct3 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct3);
    }

    public void goto_play3_start(View v)
    {
        Intent int_play3_start=new Intent();
        int_play3_start.setClass(this,StartActivity.class);
        startActivity(int_play3_start);
        finish();
    }

    /* UNDER DEVELOPMENT */
}
