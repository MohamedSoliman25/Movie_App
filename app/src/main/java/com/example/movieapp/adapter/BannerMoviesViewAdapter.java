package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.pojo.BannerMovies;

import java.util.List;

public class BannerMoviesViewAdapter extends PagerAdapter {
    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviesViewAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);
        //here i will use glide for fetching image from url and set it to image view
        Glide.with(context).load(bannerMoviesList.get(position).getBannerUrl()).into(bannerImage);
        container.addView(view);
//        bannerImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Toast.makeText(context,bannerMoviesList.get(position).getMovieName()+"" , Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, MovieDetails.class);
//
//                intent.putExtra("movieId",bannerMoviesList.get(position).getId());
//                intent.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
//                intent.putExtra("movieImageUrl",bannerMoviesList.get(position).getImageUrl());
//                intent.putExtra("movieFileUrl",bannerMoviesList.get(position).getFileUrl());
//                context.startActivity(intent);
//
//
//            }
//        });
        return view;

    }
}
