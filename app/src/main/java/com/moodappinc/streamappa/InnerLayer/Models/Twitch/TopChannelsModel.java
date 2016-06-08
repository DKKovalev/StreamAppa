package com.moodappinc.streamappa.InnerLayer.Models.Twitch;


import java.util.List;

public class TopChannelsModel {
    private List<Top> top;

    public TopChannelsModel(List<Top> topList) {
        this.top = topList;
    }

    public TopChannelsModel() {
    }

    public List<Top> getTopList() {
        return top;
    }

    public void setTopList(List<Top> topList) {
        this.top = topList;
    }

    public class Top {
        private int viewers;
        private Game game;

        public Game getGame() {
            return game;
        }

        public void setGame(Game game) {
            this.game = game;
        }

        public int getViewers() {
            return viewers;
        }

        public void setViewers(int viewers) {
            this.viewers = viewers;
        }
    }

    public class Game {
        private String name;
        private Box box;

        public Box getBox() {
            return box;
        }

        public void setBox(Box box) {
            this.box = box;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Box {
        private String large;
        private String medium;
        private String small;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

}
