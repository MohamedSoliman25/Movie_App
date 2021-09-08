package com.example.movieapp.network;

import android.graphics.Movie;

import com.example.movieapp.pojo.AllCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {
    public static final String BASE_URL="https://gist.githubusercontent.com/deepakpk009/";
    private MovieApiService movieApiService;
    public static MovieClient Instance;
    public MovieClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        movieApiService = retrofit.create(MovieApiService.class);
    }

    public static MovieClient getInstance() {
        if (Instance==null){
            Instance = new MovieClient();
        }
        return Instance;
    }

    public Observable<AllCategory> getAllCategoryMovies(){
        return movieApiService.getAllCategoryMovies();
    }
}
