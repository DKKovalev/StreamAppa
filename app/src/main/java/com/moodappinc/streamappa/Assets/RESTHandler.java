package com.moodappinc.streamappa.Assets;


import android.util.Log;

import com.moodappinc.streamappa.Assets.Models.Twitch.GamesModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TokenModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TopChannelsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RESTHandler {

    private static final String TWITCH_BASE_KRAKEN_URL = "https://api.twitch.tv/kraken/";
    private static final String TWITCH_STREAM_TOKEN_URL = "http://api.twitch.tv/api/";
    private static final String TWITCH_STREAM_URL = "http://usher.twitch.tv/api";
    private static final String MIME = "application/vnd.twitchtv.v3+json";
    private static final String CLIENT_ID = "4xrv2me643mrppdemy0wamt069yvrgh";

    public RestAdapter setupRest(String endpoint) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter;
    }

    public void getToken(String channel) {
        RESTMethods restMethods = setupRest(TWITCH_STREAM_TOKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetToken(channel, new Callback<TokenModel>() {
            @Override
            public void success(TokenModel tokenModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getStream(String channel, String token, String sig) {
        RESTMethods restMethods = setupRest(TWITCH_STREAM_URL).create(RESTMethods.class);
        restMethods.twitchGetStream(channel, "twitchweb", token, sig, "true", "true", "any", 556852, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public List<TopChannelsModel.Top> getTop() {

        final List<TopChannelsModel.Top> topList = new ArrayList<>();

        RESTMethods restMethods = setupRest(TWITCH_BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetTop(10, new Callback<TopChannelsModel>() {
            @Override
            public void success(TopChannelsModel topChannelsModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAGGERINO", error.getCause().toString());
            }
        });

        return topList;
    }
}
