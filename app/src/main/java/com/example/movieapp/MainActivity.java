package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movieapp.adapter.BannerMoviesViewAdapter;
import com.example.movieapp.adapter.MainRecyclerAdapter;

import com.example.movieapp.network.MovieClient;
import com.example.movieapp.pojo.BannerMovies;
import com.example.movieapp.pojo.Category;
import com.example.movieapp.pojo.Video;
import com.example.movieapp.viewmodel.MovieViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    BannerMoviesViewAdapter bannerMoviesPagerAdapter;
    TabLayout tabLayoutCategory,tabLayoutIndicator;
    ViewPager bannerMoviesViewPager;

    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;

    Timer sliderTimer;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    MovieViewModel movieViewModel;

    //List<AllCategory> allCategoryList;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayoutIndicator = findViewById(R.id.tab_indicator);
        tabLayoutCategory = findViewById(R.id.tab_layout);

        bannerMoviesViewPager = findViewById(R.id.banner_view_pager);
        mainRecycler = findViewById(R.id.main_recycler);


        //banners
        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies("https://i.picsum.photos/id/299/367/267.jpg?hmac=Qp5mkTp-rEX50oIvyGJPHe3CcDomZn6AA0ePaQVn7dg"));
        homeBannerList.add(new BannerMovies("https://i.picsum.photos/id/1001/367/267.jpg?hmac=h9_xzQEoMCgh9gDWOgnNnsEC9eTnf3j2BTfKXt8uu6U"));
        homeBannerList.add(new BannerMovies("https://i.picsum.photos/id/1010/367/267.jpg?hmac=QKDiobdkpYMS_L30WrGGSFAMm4lKecCNN4KYekV4nfI"));
        homeBannerList.add(new BannerMovies("https://i.picsum.photos/id/1012/367/267.jpg?hmac=KXF2aB3EVwgx_vyE1gsF6vrIRAOhP1Fl2zAKmtIvi6E"));


        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies("https://i.picsum.photos/id/1047/367/267.jpg?hmac=QGFiNj4kujOGdPq_M2omUWutggkGLFnFGZcJAwhZpbA"));
        tvShowBannerList.add(new BannerMovies("https://i.picsum.photos/id/1025/367/267.jpg?hmac=xlFGYDf9CLQQCJ2NTBxS8qTTOLkD28zsznZAt9XFCJw"));
        tvShowBannerList.add(new BannerMovies("https://i.picsum.photos/id/1024/367/267.jpg?hmac=pOq95j6N3CkJ1yXDdkh3xMr03DalA77-7v1aAyp4nWE"));
        tvShowBannerList.add(new BannerMovies("https://i.picsum.photos/id/1026/367/267.jpg?hmac=prF35YFx9-apfzpe3aJ8ukBG5LdXc7jqoT7g8Xlid1M"));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies("https://i.picsum.photos/id/1082/367/267.jpg?hmac=dxh1232zyYkpCAP1gaE65KnDOnnyKrcAOI1f2gMp7hM"));
        movieBannerList.add(new BannerMovies("https://i.picsum.photos/id/1055/367/267.jpg?hmac=k1pRXCvZrcYGN8PFvd-u0ZLJO4GfD_mG2AtvrSKHxks"));
        movieBannerList.add(new BannerMovies("https://i.picsum.photos/id/1072/367/267.jpg?hmac=3X5KNBUdLKVOWynjzeZetRb5PN9w1j1Qu7wgjnL8JAs"));
        movieBannerList.add(new BannerMovies("https://i.picsum.photos/id/129/367/267.jpg?hmac=mN9-fBaKpaTVGyPH4sqmd-mvkFgkp8CSP78L2ze5aVs"));



        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies("https://i.picsum.photos/id/1066/367/267.jpg?hmac=h6fQgSjq583aU2U3-9V7ac4VIL7GbHC9n0bKBc6Wt6s"));
        kidsBannerList.add(new BannerMovies("https://i.picsum.photos/id/146/367/267.jpg?hmac=aO6rNBRDzc72NxkbEuqUEms-k1KRF7EYjtqtGV5koUA"));
        kidsBannerList.add(new BannerMovies("https://i.picsum.photos/id/163/367/267.jpg?hmac=2knIU_Lxlu_eGgTd_dptradHoHiMEW4DopRIMJPXKu8"));
        kidsBannerList.add(new BannerMovies("https://i.picsum.photos/id/275/367/267.jpg?hmac=jkMS_34BthqBc02n-14hLhegqHPuvOt7zmBlNqUF5fg"));




        //this is default tab selected
        setBannerMoviesPagerAdapter(homeBannerList);
        //on tap change selected data for banner
        tabLayoutCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){

                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getAllCategoryMovies();
        movieViewModel.getMovieListMutableLiveData().observe(this, new Observer<List<Video>>() {
                    @Override
                    public void onChanged(List<Video> videos) {
                        //here we pass array to recycler setup method
                        setMainRecycler(videos);
                    }
                });



    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesPagerAdapter = new BannerMoviesViewAdapter(this, bannerMoviesList);
        //for showing banner in view pager
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        bannerMoviesPagerAdapter.notifyDataSetChanged();

        //for selected and unselected banner indicator
        tabLayoutIndicator.setupWithViewPager(bannerMoviesViewPager);

        // continue setup auto slider view pager
         sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        tabLayoutIndicator.setupWithViewPager(bannerMoviesViewPager, true);
    }

    // setup auto slider view pager
    class AutoSlider extends TimerTask {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem()< homeBannerList.size()-1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                    else {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
    public void setMainRecycler(List<Video> mList){
        mainRecycler.setLayoutManager(new GridLayoutManager(this,2));
        mainRecyclerAdapter = new MainRecyclerAdapter(this,mList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
        mainRecyclerAdapter.notifyDataSetChanged();
    }

}