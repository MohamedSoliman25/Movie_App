package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.R;

public class SplashScreen extends AppCompatActivity {
    Animation topAnimation,bottomAnimation;
    ImageView imageView;
    TextView newsFeed;
    private static int SPLASH_SCREEN = 4000;

    //    ProgressBar progressBar;
//    int count=0;
//    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.splash_img);
        newsFeed = findViewById(R.id.splash_text);

//        progressBar=findViewById(R.id.progress_bar);
//        getProgressTimer();
//        topAnimation.setDuration(2000);
//        bottomAnimation.setDuration(2000);
        imageView.setAnimation(topAnimation);
        newsFeed.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN);
    }

}