package com.moodappinc.streamappa.Assets.Models.Hitbox;

public class GameModel {
    private Categories category;

    public GameModel(Categories category) {
        this.category = category;
    }

    public GameModel() {
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
