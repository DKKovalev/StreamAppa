package com.moodappinc.streamappa.InnerLayer.Models.Hitbox;

import java.util.List;

public class GamesModel {
    private List<Categories> categories;

    public GamesModel(List<Categories> categoriesList) {
        this.categories = categoriesList;
    }

    public GamesModel() {
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }


}

