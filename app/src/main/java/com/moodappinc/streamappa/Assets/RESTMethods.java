package com.moodappinc.streamappa.Assets;


import com.moodappinc.streamappa.Assets.Models.Hitbox.HitboxLiveStreams;
import com.moodappinc.streamappa.Assets.Models.Twitch.ChannelModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TokenModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TopChannelsModel;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RESTMethods {
    @GET("/streams/{channel}")
    void twitchGetChannel(@Path("channel") String channel, Callback<ChannelModel> channelModelCallback);

    @GET("/channels/{channel}/access_token")
    void twitchGetToken(@Path("channel") String channel, Callback<TokenModel> tokenModelCallback);

    @GET("/games/top")
    void twitchGetTop(@Query("limit") int limit, Callback<TopChannelsModel> topChannelsModelCallback);

    @GET("/streams")
    void twitchGetChannelsByGame(@Query("game") String game, Callback<com.moodappinc.streamappa.Assets.Models.Twitch.GamesModel> gamesModelCallback);

    @GET("/channel/hls/{channel}.m3u8")
    void twitchGetStream(@Path("channel") String channel
            , @Query("player") String player
            , @Query("token") String token
            , @Query("sig") String sig
            , @Query("allow_audio_only") String audioOnly
            , @Query("allow_source") String allowSource, @Query("type") String type
            , @Query("p") int randomInt
            , Callback<Response> streamCallback);

    @GET("/media/live/list")
    void hitboxGetGames(Callback<HitboxLiveStreams> gamesModelCallback);
}
