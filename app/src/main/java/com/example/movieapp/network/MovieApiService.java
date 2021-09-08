package com.example.movieapp.network;

import com.example.movieapp.pojo.AllCategory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieApiService {

@GET("99fd994da714996b296f11c3c371d5ee/raw/28c4094ae48892efb71d5122c1fd72904088439b")
     Observable<AllCategory> getAllCategoryMovies();
}
