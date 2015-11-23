package com.moodappinc.streamappa.Assets;


import com.moodappinc.streamappa.Assets.Models.ChannelModel;
import com.moodappinc.streamappa.Assets.Models.GamesModel;
import com.moodappinc.streamappa.Assets.Models.TokenModel;
import com.moodappinc.streamappa.Assets.Models.TopChannelsModel;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RESTMethods {
    @GET("/streams/{channel}")
    void getChannel(@Path("channel") String channel, Callback<ChannelModel> channelModelCallback);
    @GET("/channels/{channel}/access_token")
    void getToken(@Path("channel") String channel, Callback<TokenModel> tokenModelCallback);
    @GET("/games/top")
    void getTop(@Query("limit") int limit, Callback<TopChannelsModel> topChannelsModelCallback);
    @GET("/streams")
    void getChannelsByGame(@Query("game") String game, Callback<GamesModel> gamesModelCallback);
    @GET("/channel/hls/{channel}.m3u8")
    void getStream(@Path("channel") String channel
            , @Query("player") String player
            , @Query("token") String token
            , @Query("sig") String sig
            , @Query("allow_audio_only") String audioOnly
            , @Query("allow_source") String allowSource, @Query("type") String type
            , @Query("p") int randomInt
            , Callback<Response> streamCallback);
}
