package com.adhiraj.myshield.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.adhiraj.myshield.Games.HighOrLowActivity;
import com.adhiraj.myshield.Games.MathMasterActivity;
import com.adhiraj.myshield.R;

public class MiniGamesActivity extends AppCompatActivity {

    RelativeLayout high_low, maths_master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_games);

        high_low = findViewById(R.id.high_low);
        maths_master = findViewById(R.id.math_master);

        high_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HighOrLowActivity.class));
            }
        });

        maths_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(), MathMasterActivity.class));
            }
        });

    }
}