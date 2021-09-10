package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;

import java.util.ArrayList;

public class MovieDetails extends AppCompatActivity {

    ImageView movieImage;
    TextView movieTitleTv,movieSubTitleTv,movieDescriptionTv;
    ImageButton play;
    String description,subTitle,title,thumb;
    ArrayList<String> sources=null;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
       movieImage =  findViewById(R.id.details_image);
        movieTitleTv = findViewById(R.id.details_title);
        movieSubTitleTv = findViewById(R.id.details_sub_title);
        movieDescriptionTv = findViewById(R.id.details_description);


        play= findViewById(R.id.play_button);

        //get data from intent from bannerAdapter & itemRecyclerAdapter
        description = getIntent().getStringExtra("description");
        sources = getIntent().getStringArrayListExtra("sources");
        subTitle = getIntent().getStringExtra("subTitle");
        title = getIntent().getStringExtra("title");
        thumb = getIntent().getStringExtra("thumb");
        position = getIntent().getIntExtra("position",0);


        Glide.with(this).load(thumb).into(movieImage);
        movieTitleTv.setText(title);
        movieSubTitleTv.setText(subTitle);
        movieDescriptionTv.setText(description);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = null;
                Intent intent = new Intent(MovieDetails.this,VedioPlayerActivity.class);
                switch (position){
                    case 0:
                       url = sources.get(0);
                        break;
                    case 1:
                        url = sources.get(1);
                        break;
                    case 2:
                        url = sources.get(2);
                        break;
                    case 3:
                        url = sources.get(3);
                        break;
                    case 4:
                        url = sources.get(4);
                        break;
                    case 5:
                        url = sources.get(5);
                        break;
                    case 6:
                        url = sources.get(6);
                        break;
                    case 7:
                        url = sources.get(7);
                        break;
                    case 8:
                        url = sources.get(8);
                        break;
                    case 9:
                        url = sources.get(9);
                        break;
                    case 10:
                        url = sources.get(10);
                        break;
                    case 11:
                        url = sources.get(11);
                        break;
                    case 12:
                        url = sources.get(12);
                        break;
                    case 13:
                        url = sources.get(13);
                        break;

                }
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }
}