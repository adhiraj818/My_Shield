package com.adhiraj.myshield.Games;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhiraj.myshield.R;

import java.util.ArrayList;
import java.util.Random;

public class MathMasterActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    ImageView b;
    ImageButton resetb,infob;
    TextView txt1,txt2,txt3,txtsum,txt4,txt5;
    ConstraintLayout cl;
    MediaPlayer media;
    ArrayList<Integer> ans=new ArrayList<Integer>();
    Integer loc,score=0,ques=0,count=0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_master);

        b=(ImageView) findViewById(R.id.b);
        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txtsum=(TextView)findViewById(R.id.txtsum);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);
        cl=(ConstraintLayout)findViewById(R.id.ConstraintLayout);
        resetb=(ImageButton)findViewById(R.id.resetb);
        infob=(ImageButton)findViewById(R.id.infob);

        media=MediaPlayer.create(this,R.raw.suspense);

        b.setVisibility(View.VISIBLE);
        infob.setVisibility(View.VISIBLE);
        txt1.setVisibility(View.VISIBLE);


        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);


        newquestion();

        countDownTimer = new CountDownTimer(30500,1000){

            @Override
            public void onTick(long l) {

                txt2.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {
                txt4.setText("Final score is "+ txt3.getText());
                txt2.setVisibility(View.INVISIBLE);
                txt3.setVisibility(View.INVISIBLE);
                txtsum.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                resetb.setVisibility(View.VISIBLE);
            }
        };

    }


    @Override
    protected  void onStop(){
        super.onStop();
        media.stop();

    }

    public void newquestion(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        txtsum.setText(Integer.toString(a)+"+"+Integer.toString(b)+"= ?");
        loc=rand.nextInt(4);
        ans.clear();
        int incorrect;

        for(int i=0;i<4;i++){

            if(i==loc){
                ans.add(a+b);
            }else{
                incorrect=rand.nextInt(41);
                while(incorrect == a+b){
                    incorrect=rand.nextInt(41);
                }
                ans.add(incorrect);
            }
        }

        b1.setText(Integer.toString(ans.get(0)));
        b2.setText(Integer.toString(ans.get(1)));
        b3.setText(Integer.toString(ans.get(2)));
        b4.setText(Integer.toString(ans.get(3)));
    }

    public void chooseanswer(View view){
        txt4.setVisibility(View.VISIBLE);
        Log.i("tag",(String)view.getTag());
        if(view.getTag().toString().equals(Integer.toString(loc))){
            txt4.setVisibility(View.VISIBLE);
            txt4.setText("CORRECT");
            score++;
        }else{
            txt4.setText("INCORRECT");
        }
        ques++;
        txt3.setText(Integer.toString(score)+"/"+Integer.toString(ques));
        newquestion();

    }

    public void onclickgo(View view){

        b.setVisibility(View.INVISIBLE);
        txt1.setVisibility(View.INVISIBLE);
        infob.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.VISIBLE);
        txtsum.setVisibility(View.VISIBLE);

        cl.setBackgroundResource(R.drawable.mathsbg);
        media.start();
        countDownTimer.start();

    }

    public void onclicksound(View view){
        if(count%2==0){
            media.pause();
            b5.setText("UNMUTE");
        }else{
            media.start();
            b5.setText("MUTE");
        }
        count++;
    }

    public void onclickreset(View view){
        new CountDownTimer(30500,1000){

            @Override
            public void onTick(long l) {

                txt2.setText(String.valueOf(l/1000));

            }
            @Override
            public void onFinish() {
                txt4.setText("Final score is "+ txt3.getText());
                txt2.setVisibility(View.INVISIBLE);
                txt3.setVisibility(View.INVISIBLE);
                txtsum.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                resetb.setVisibility(View.VISIBLE);

            }

        }.start();

        score=0;
        ques=0;
        txt3.setText("0/0");
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.VISIBLE);
        txt4.setVisibility(View.INVISIBLE);
        txtsum.setVisibility(View.VISIBLE);
        resetb.setVisibility(View.INVISIBLE);

    }

    public void onclickinfo(View view){

        b.setVisibility(View.INVISIBLE);
        txt1.setVisibility(View.INVISIBLE);
        txt5.setVisibility(View.VISIBLE);
        infob.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.VISIBLE);
    }

    public void onclickback(View view){
        b.setVisibility(View.VISIBLE);
        txt1.setVisibility(View.VISIBLE);
        txt5.setVisibility(View.INVISIBLE);
        infob.setVisibility(View.VISIBLE);
        b6.setVisibility(View.INVISIBLE);
    }

}