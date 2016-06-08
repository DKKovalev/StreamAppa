package com.moodappinc.streamappa.OuterLevel.Network;

import retrofit.RestAdapter;

/**
 * Created by d.kovalev on 08.06.2016.
 */
public class NetworkHandler {

    protected static final String TWITCH_BASE_KRAKEN_URL = "https://api.twitch.tv/kraken/";
    protected static final String TWITCH_STREAM_TOKEN_URL = "http://api.twitch.tv/api/";
    protected static final String TWITCH_STREAM_URL = "http://usher.twitch.tv/api";
    protected static final String MIME = "application/vnd.twitchtv.v3+json";
    protected static final String CLIENT_ID = "4xrv2me643mrppdemy0wamt069yvrgh";

    public RestAdapter setupRest(String endpoint) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter;
    }
}
