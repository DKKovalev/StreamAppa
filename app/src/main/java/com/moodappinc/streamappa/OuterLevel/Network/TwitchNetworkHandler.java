package com.moodappinc.streamappa.OuterLevel.Network;

import com.moodappinc.streamappa.InnerLayer.Models.Twitch.GamesModel;
import com.moodappinc.streamappa.InnerLayer.Models.Twitch.TokenModel;
import com.moodappinc.streamappa.InnerLayer.Models.Twitch.TopChannelsModel;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by d.kovalev on 08.06.2016.
 */
public class TwitchNetworkHandler extends NetworkHandler {

    public void getCurrentTopGames() {

        RESTMethods restMethods = setupRest(TWITCH_BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetTop(10, new Callback<TopChannelsModel>() {
            @Override
            public void success(TopChannelsModel topChannelsModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getChannelsByGame(String game) {
        RESTMethods restMethods = setupRest(TWITCH_BASE_KRAKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetChannelsByGame(game, new Callback<GamesModel>() {
            @Override
            public void success(GamesModel gamesModel, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    private void getToken(final String channel) {
        RESTMethods restMethods = setupRest(TWITCH_STREAM_TOKEN_URL).create(RESTMethods.class);
        restMethods.twitchGetToken(channel, new Callback<TokenModel>() {
            @Override
            public void success(TokenModel tokenModel, Response response) {
                String token = tokenModel.getToken();
                token = token.replace("\\", "");
                //getStream(channel, token, tokenModel.getSig());
                String url = TWITCH_STREAM_URL + "channel/hls/" + channel + ".m3u8?player=twitchweb&&token=" + token + "&sig=" + tokenModel.getSig() + "&allow_audio_only=true&allow_source=true&type=any&p=556852";
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
