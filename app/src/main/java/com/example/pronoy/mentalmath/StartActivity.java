package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    //Basic buttons' / options declarations
    Button b1=(Button) findViewById(R.id.button_mentaladd);
    Button b2=(Button) findViewById(R.id.button_numbermem);
    Button b3=(Button) findViewById(R.id.button_squareroot);
    Button b4=(Button) findViewById(R.id.button_numbershape);
  }

  //These functions are designed to take you from this start screen to the individual game screens

  /* For naming intent variables following is the convention used
  int_<name of activity you are in>_<name of activity you want to go to>
   */

  public void goto_start_instruct1(View v)
  {
    Intent int_start_instruct1=new Intent();
    int_start_instruct1.setClass(this,Instruct1.class);
    startActivity(int_start_instruct1);
    finish();
  }

  public void goto_start_instruct2(View v)
  {
    Intent int_start_instruct2=new Intent();
    int_start_instruct2.setClass(this,Instruct2.class);
    startActivity(int_start_instruct2);
    finish();
  }

  public void goto_start_instruct3(View v)
  {
    Intent int_start_instruct3=new Intent();
    int_start_instruct3.setClass(this,Instruct3.class);
    startActivity(int_start_instruct3);
    finish();
  }

  public void goto_start_instruct4(View v)
  {
    Intent int_start_instruct4=new Intent();
    int_start_instruct4.setClass(this,Instruct4.class);
    startActivity(int_start_instruct4);
    finish();
  }
}
