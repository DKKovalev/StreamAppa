package com.moodappinc.streamappa.Assets;


import com.moodappinc.streamappa.Assets.Models.GamesModel;
import com.moodappinc.streamappa.Assets.Models.TokenModel;
import com.moodappinc.streamappa.Assets.Models.TopChannelsModel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RESTHandler {
    private RestAdapter restAdapter;

    private static final String BASE_KRAKEN_URL = "https://api.twitch.tv/kraken/";
    private static final String STREAM_TOKEN_URL = "http://api.twitch.tv/api/";
    private static final String STREAM_URL = "http://usher.twitch.tv/api";
    private static final String MIME = "application/vnd.twitchtv.v3+json";
    private static final String CLIENT_ID = "4xrv2me643mrppdemy0wamt069yvrgh";

    private RestAdapter setupRest(String endpoint) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter;
    }

    public void getChannelsByGame(String game) {
        RESTMethods restMethods = setupRest(BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.getChannelsByGame(game, new Callback<GamesModel>() {
            @Override
            public void success(GamesModel gamesModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getToken(String channel){
        RESTMethods restMethods = setupRest(STREAM_TOKEN_URL).create(RESTMethods.class);
        restMethods.getToken(channel, new Callback<TokenModel>() {
            @Override
            public void success(TokenModel tokenModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getStream(String channel, String token, String sig){
        RESTMethods restMethods = setupRest(STREAM_URL).create(RESTMethods.class);
        restMethods.getStream(channel, "twitchweb", token, sig, "true", "true", "any", 556852, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getTop(){
        RESTMethods restMethods = setupRest(BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.getTop(10, new Callback<TopChannelsModel>() {
            @Override
            public void success(TopChannelsModel topChannelsModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
