package com.moodappinc.streamappa.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moodappinc.streamappa.Assets.CustomRecyclerAdapter;
import com.moodappinc.streamappa.Assets.Models.Twitch.TopChannelsModel;
import com.moodappinc.streamappa.Assets.RESTHandler;
import com.moodappinc.streamappa.Assets.RESTMethods;
import com.moodappinc.streamappa.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class TwitchTab extends Fragment implements CustomRecyclerAdapter.OnRecyclerItemClicker {

    private RecyclerView recyclerView;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private RESTHandler restHandler;
    private List<TopChannelsModel.Top> topList;

    public TwitchTab() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restHandler = new RESTHandler();
        topList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_twitch_tab, container, false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) view.findViewById(R.id.twitch_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        getTop();

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

    private void getTop() {

        RESTMethods restMethods = restHandler.setupRest(getString(R.string.twitch_kraken_url)).create(RESTMethods.class);
        restMethods.twitchGetTop(10, new Callback<TopChannelsModel>() {
            @Override
            public void success(TopChannelsModel topChannelsModel, Response response) {

                topList = topChannelsModel.getTopList();
                customRecyclerAdapter = new CustomRecyclerAdapter(topList, null, null, getActivity());
                recyclerView.setAdapter(customRecyclerAdapter);
                customRecyclerAdapter.setOnRecyclerItemClicker(TwitchTab.this);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAGGERINO", error.getCause().toString());
            }
        });
    }

    @Override
    public void itemClicked(View view, int pos) {

        Toast.makeText(getActivity(), "TAP", Toast.LENGTH_LONG).show();

        String gameTitle = topList.get(pos).getGame().getName();

        TwitchTopChannels twitchTopChannels = new TwitchTopChannels();

        Bundle bundle = new Bundle();
        bundle.putString("twitch_game_title", gameTitle);
        twitchTopChannels.setArguments(bundle);

        this.getFragmentManager().beginTransaction().replace(R.id.viewpager, twitchTopChannels).addToBackStack(null).commit();
    }
}
