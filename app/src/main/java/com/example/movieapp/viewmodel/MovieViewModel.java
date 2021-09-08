package com.example.movieapp.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.network.MovieClient;
import com.example.movieapp.pojo.AllCategory;
import com.example.movieapp.pojo.Category;
import com.example.movieapp.pojo.Video;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {

    MutableLiveData<List<Video>> movieListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<String>>movieSourcesMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "MovieViewModel";

    public LiveData<List<Video>> getMovieListMutableLiveData() {
        return movieListMutableLiveData;
    }

    @SuppressLint("CheckResult")
    public void getAllCategoryMovies(){
        MovieClient.getInstance().getAllCategoryMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res-> movieListMutableLiveData.setValue(res.getCategories().get(0).getVideos()), e-> Log.d(TAG, "error"+e.getMessage()));

    }

}
