package com.moodappinc.streamappa.InnerLayer.Models.Hitbox;


import java.util.List;

public class HitboxLiveStreams {

    private List<Livestream> livestream;

    public HitboxLiveStreams(List<Livestream> livestream) {
        this.livestream = livestream;
    }

    public List<Livestream> getLivestream() {
        return livestream;
    }

    public void setLivestream(List<Livestream> livestream) {
        this.livestream = livestream;
    }

    public class Livestream {
        private String media_user_name;
        private String media_file;
        private String media_status;
        private String category_name;
        private String media_thumbnail_large;

        public String getMedia_user_name() {
            return media_user_name;
        }

        public void setMedia_user_name(String media_user_name) {
            this.media_user_name = media_user_name;
        }

        public String getMedia_thumbnail_large() {
            return media_thumbnail_large;
        }

        public void setMedia_thumbnail_large(String media_thumbnail_large) {
            this.media_thumbnail_large = media_thumbnail_large;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getMedia_status() {
            return media_status;
        }

        public void setMedia_status(String media_status) {
            this.media_status = media_status;
        }

        public String getMedia_file() {
            return media_file;
        }

        public void setMedia_file(String media_file) {
            this.media_file = media_file;
        }
    }
}
