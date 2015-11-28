package com.moodappinc.streamappa.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moodappinc.streamappa.Assets.CustomRecyclerAdapter;
import com.moodappinc.streamappa.Assets.Models.Twitch.GamesModel;
import com.moodappinc.streamappa.Assets.RESTHandler;
import com.moodappinc.streamappa.Assets.RESTMethods;
import com.moodappinc.streamappa.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TwitchTopChannels extends Fragment implements CustomRecyclerAdapter.OnRecyclerItemClicker {

    private RESTHandler restHandler;
    private RecyclerView recyclerView;
    private CustomRecyclerAdapter customRecyclerAdapter;

    private List<GamesModel.Streams> streamsList;

    public TwitchTopChannels() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restHandler = new RESTHandler();
        streamsList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_twitch_top_channels, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.twitch_top_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        String game  = getArguments().getString("twitch_game_title");
        getChannelsByGame(game);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private void getChannelsByGame(String game) {
        RESTMethods restMethods = restHandler.setupRest(getString(R.string.twitch_kraken_url)).create(RESTMethods.class);
        restMethods.twitchGetChannelsByGame(game, new Callback<GamesModel>() {
            @Override
            public void success(GamesModel gamesModel, Response response) {
                streamsList = gamesModel.getStreams();

                customRecyclerAdapter = new CustomRecyclerAdapter(null, null, streamsList, getActivity());
                customRecyclerAdapter.setOnRecyclerItemClicker(TwitchTopChannels.this);
                recyclerView.setAdapter(customRecyclerAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    @Override
    public void itemClicked(View view, int pos) {

    }
}
