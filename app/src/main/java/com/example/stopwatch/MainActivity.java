package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button start,finish;
    Chronometer chronometer;
    Animation animation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start =findViewById(R.id.buttonStart);
        finish = findViewById(R.id.buttonFinish);
        chronometer = findViewById(R.id.time);
        imageView =findViewById(R.id.image);
        animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotation);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
                chronometer.setFormat("%s");
               chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                start.setVisibility(View.INVISIBLE);
                finish.setVisibility(View.VISIBLE);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                animation.cancel();
                imageView.setAnimation(animation);
                start.setVisibility(View.VISIBLE);
                finish.setVisibility(View.INVISIBLE);

            }
        });

    }
}
