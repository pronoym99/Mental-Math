package com.example.pronoy.mentalmath;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Play1 extends AppCompatActivity
{
  @Override
    protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_play1);
    final Button b1=(Button) findViewById(R.id.button_submit);
    final Button b2=(Button) findViewById(R.id.button_ret_mainscreen);
    final Button b3=(Button) findViewById(R.id.button_exit);
    final ImageView img=(ImageView) findViewById(R.id.imageView_result);
    final EditText et=(EditText) findViewById(R.id.editText_anstext);


    //Bringing in information from the previous activity

    /* For naming caller variables following is the convention used
  int_<name of activity you are in>_<name of activity youcame from>
   */
    Intent caller_play1_instruct1=getIntent();
    final int c=caller_play1_instruct1.getIntExtra("count",10);
    final int f=caller_play1_instruct1.getIntExtra("frequency",1);


    //for handling time related tasks
    final Handler h=new Handler();

    /* Runnable method will recall the method the method in which it was defined
     because of which an implicit loop would be created.
     The variable total time bounds the loop to go on indefinitely.
      */
    Runnable r=new Runnable()
    {

      int count=c;
      int correct_sum=0;
      @Override
      public void run()
      {
        Random rand=new Random();                          //Random number generation
        int n=rand.nextInt(9)+1;                    // in the closed interval [0,9]
        correct_sum+=n;                                    // computing sum value to be checked later
        final TextView tv=(TextView) findViewById(R.id.textView_numdisplay);
        tv.setText(""+n);
        count--;                                           //decrementing count value by one unit
        if(count>0 && count%2==0)                         //MASTER CONDITION: prevents infinite loop; count>0
        {
          tv.setTextColor(Color.RED);
          h.postDelayed(this,1000*f);         //units are in ms so frequency f is multiplied with 1000 to obtain the required delay
        }
        else if(count>0 && count%2!=0)
        {
          tv.setTextColor(Color.BLUE);                     //alternate colors i.e. red and blue help distinguish consecutive numbers which could be the same
          h.postDelayed(this,1000*f);
        }

        /* The following condition satisfies multiple functionalities:
        (a) Would be executed only when the number show is over therefore the buttons
         and the entry field is visible only after this stage.
         (b) Has the OnClicklistener for the submit button embedded inside it
         */

        else if(count<=0)
        {
          b1.setVisibility(View.VISIBLE);
          et.setVisibility(View.VISIBLE);
          b1.setOnClickListener(new View.OnClickListener()
          {
            @Override
            public void onClick(View v)
            {
              /* This listener event satisfies multiple functionalities:
              (a) Makes the remaining two buttons visible only after this button has been pressed
              (b) Does the score calculation and displays the result accordingly after modifying the text view suitably
               */

              b2.setVisibility(View.VISIBLE);
              b3.setVisibility(View.VISIBLE);
              int user_sum=Integer.parseInt(""+et.getText());

              /* for more details on the scoring techniques refer to the instructions
              on the first page
               */
              if(user_sum==correct_sum)
              {
                double _f=f;
                double _c=c;
                int win_score=(int)(_c/_f);
                img.setImageResource(R.drawable.correct);                 //set the tick symbol in the image view
                tv.setTextSize(25);
                tv.setTextColor(Color.BLUE);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setText("Your Score is:\n"+win_score);
              }
              else if(user_sum!=correct_sum)
              {
                int lose_score=-Math.abs(correct_sum-user_sum);           //set the cross symbol in the image view
                img.setImageResource(R.drawable.wrong);
                tv.setTextSize(25);
                tv.setTextColor(Color.RED);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setText("Your Score is:\n"+lose_score);
              }
            }
          });
        }
      }
    };

    //handler would be called for the first time here
    h.postDelayed(r,1000*f);
  }

  public void goto_play1_start(View v)
  {
    Intent int_play1_start=new Intent();
    int_play1_start.setClass(this,StartActivity.class);
    startActivity(int_play1_start);
    finish();
  }

  public void exit(View v)
  {
    System.exit(0);
  }
}
