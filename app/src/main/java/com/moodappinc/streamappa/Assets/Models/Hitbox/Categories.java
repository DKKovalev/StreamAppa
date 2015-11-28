package com.moodappinc.streamappa.Assets.Models.Hitbox;

public class Categories {

    private int category_id;
    private String category_name;
    private String category_seo_key;
    private String category_logo_large;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_seo_key() {
        return category_seo_key;
    }

    public void setCategory_seo_key(String category_seo_key) {
        this.category_seo_key = category_seo_key;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_logo_large() {
        return category_logo_large;
    }

    public void setCategory_logo_large(String category_logo_large) {
        this.category_logo_large = category_logo_large;
    }
}
