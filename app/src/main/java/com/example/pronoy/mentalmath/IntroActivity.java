package com.example.pronoy.mentalmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    //Basic view and layout declaration and settings
    final ScrollView sv=(ScrollView) findViewById(R.id.intro_scroll);
    TextView tv=(TextView) findViewById(R.id.intro_text);
    final Button b=(Button) findViewById(R.id.button_get_started);


    //Setting other necessary parameters regarding the above declarations
    sv.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
    tv.setText("With the invent of advanced calculators and computers we have are closer to technolgy than ever before.\n" +
            " However due to these advancements in technology our brains have become lazier over time and has subsequently lost speed and concentration abilities.\n " +
            "This app is inspired from the Memoriad World Cup which pits human calculators against each other in a hard faught battle.\n" +
            "It consists of simple games based on mental mathematics and others which is a guaranteed fun for the whole family\n" +
            "AND ATTEMPTS TO BRING BACK THE LOST GLORY OF THE SUPERFAST HUMAN BRAIN\n" +
            "Then what are you waiting for......");

    //This method makes the button visible only when the end of the scroll view is reached
    sv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener()
    {
      @Override
      public void onScrollChanged()
      {
        if(sv.getChildAt(0).getBottom()<=sv.getHeight()+sv.getScrollY())
        {
          b.setVisibility(View.VISIBLE);
        }
      }
    });
  }

  public void goto_intro_start(View v)
  {
    Intent int_intro_start=new Intent();
    int_intro_start.setClass(this,StartActivity.class);
    startActivity(int_intro_start);
    finish();
  }
}
