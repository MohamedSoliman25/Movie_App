package com.example.movieapp.pojo;

import java.util.List;


public class Category {


    private String name;

    private List<Video> videos = null;

    public Category(String name, List<Video> videos) {
        this.name = name;
        this.videos = videos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}