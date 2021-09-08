package com.example.movieapp.pojo;

import java.util.List;


public class AllCategory {


    private List<Category> categories = null;

    public AllCategory(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}