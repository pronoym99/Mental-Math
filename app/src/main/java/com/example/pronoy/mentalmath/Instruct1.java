package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Instruct1 extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_instruct1);

      //Basic view and layout declaration and settings
      TextView tv=(TextView) findViewById(R.id.textView_instruct1);
      Button b=(Button) findViewById(R.id.button_play1);

      //Setting other necessary parameters regarding the above declarations

      tv.setText("INSTRUCTIONS\n" +
              "1. This task consists of quick mental addition of single digit numbers.\n " +
              "2. Numbers would be displayed at a fixed frequency set by the user in the frequency box below\n" +
              "3. The total numbers to be displyed in a single attempt can also be set in the count value box below.\n"+
              "4. The numbers start rolling on the screen without any delay immediately on pressing the PLAY button, SO BE READY\n"+
              "5. Setting a frequncy less than the count value would result in zero score\n"+
              "6. The user needs to enter the sum in the box displayed at the end.\n\n" +
              "SCORING\n " +
              "1. If your answer is correct you would be rewarded with a score which is the product of your number count and the inverse of your frequency\n " +
              "2. If your answer is incorrect you would be awarded negative marks worth the absolute deviation from the actual/correct sum"
      );
  }

  public void goto_instruct1_play1(View v)
  {
    EditText et1=(EditText) findViewById(R.id.editText_countvalue);
    EditText et2=(EditText) findViewById(R.id.editText_frequency);
    if(Integer.parseInt("" + et1.getText())==0||Integer.parseInt("" + et2.getText())==0)
    {
      //gives a message if the count value or freuency is zero and doesn'yt proceed to the next page
      Toast.makeText(getApplicationContext(),"Count value or frequency can't be 0",Toast.LENGTH_LONG).show();
    }
    else
    {
      Intent int_instruct1_play1 = new Intent();
      int_instruct1_play1.setClass(this, Play1.class);
      int_instruct1_play1.putExtra("count", Integer.parseInt("" + et1.getText()));
      int_instruct1_play1.putExtra("frequency", Integer.parseInt("" + et2.getText()));
      startActivity(int_instruct1_play1);
      finish();
    }
  }
}
