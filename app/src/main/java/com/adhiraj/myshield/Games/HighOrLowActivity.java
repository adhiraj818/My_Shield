package com.adhiraj.myshield.Games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adhiraj.myshield.R;

public class HighOrLowActivity extends AppCompatActivity {

    int random = (int)(Math.random() * 30 + 1);
    int n,x=4;
    ImageView img,img1;
    Button b1,b2;


    EditText edt;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_or_low);

        img=(ImageView)findViewById(R.id.imgv2);
        img.animate().alpha(0f).setDuration(1);

    }




    public  void onclickenter(View view)
    {
        String s,s1;

        edt =(EditText)findViewById(R.id.etxt);
        txt=(TextView)findViewById(R.id.txt2);
        img=(ImageView)findViewById(R.id.imgv2);
        img.animate().alpha(0f).setDuration(1);
        s=edt.getText().toString();
        s1=txt.getText().toString();

        n=Integer.parseInt(s);
        if(n==random)
        {
            img.animate().alpha(1f).setDuration(1500);
            edt.setText("");
            Toast.makeText(this,"click reset for New Game",Toast.LENGTH_LONG).show();
            txt.setText("!!You Won!!");

        }
        else if(n<random)
        {

            if(x<1)
            {
                Toast.makeText(this,"GAME OVER\nclick reset to start a new game"+s,Toast.LENGTH_LONG).show();
                txt.setText("YOU LOOSE");
                x=4;
            }
            else
            {
                Toast.makeText(this, "guess a no. greater than" + s, Toast.LENGTH_LONG).show();
                s1 = txt.getText().toString();
                txt.setText("Attempt Left::"+x);
                x--;
            }

        }
        else if(n>random)
        {
            if(x<1)
            {
                Toast.makeText(this,"GAME OVER\nclick reset to start a new game"+s,Toast.LENGTH_LONG).show();
                txt.setText("YOU LOOSE");
                x=4;
            }
            else
            {
                Toast.makeText(this, "guess a no. smaller than" +s, Toast.LENGTH_LONG).show();
                s1 = txt.getText().toString();
                txt.setText("Attempt Left::"+x);
                x--;
            }
        }
        else
        {
            txt.setText("");
        }
    }

    public void onclickimg(View view)
    {
        img1=(ImageView)findViewById(R.id.img1);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.animate().alpha(1).setDuration(3000);
        b2.animate().alpha(1).setDuration(3000);

        img1.animate().translationX(1000f).alpha(0).setDuration(2000);

    }

    public void onclickreset(View view)
    {
        int rand = (int)(Math.random() * 20 + 1);
        random=rand;
        img=(ImageView)findViewById(R.id.imgv2);
        img.animate().alpha(0f).setDuration(1500);
        txt=(TextView)findViewById(R.id.txt2);
        txt.setText("Attempt Left::5");
        x=4;

    }


}