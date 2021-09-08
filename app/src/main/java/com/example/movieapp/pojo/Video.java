
package com.example.movieapp.pojo;

import java.util.List;


public class Video {


    private String description;

    private List<String> sources = null;

    private String subtitle;

    private String thumb;

    private String title;

    public Video(String description, List<String> sources, String subtitle, String thumb, String title) {
        this.description = description;
        this.sources = sources;
        this.subtitle = subtitle;
        this.thumb = thumb;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}