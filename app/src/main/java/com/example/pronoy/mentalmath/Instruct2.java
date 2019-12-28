package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instruct2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct2);
    }

    public void goto_play2_start(View v)
    {
        Intent int_play2_start=new Intent();
        int_play2_start.setClass(this,StartActivity.class);
        startActivity(int_play2_start);
        finish();
    }

    /* UNDER DEVELOPMENT */
}
