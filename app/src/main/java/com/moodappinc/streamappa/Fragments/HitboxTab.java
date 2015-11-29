package com.moodappinc.streamappa.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moodappinc.streamappa.Activities.StreamPlayerActivity;
import com.moodappinc.streamappa.Assets.CustomRecyclerAdapter;
import com.moodappinc.streamappa.Assets.Models.Hitbox.GamesModel;
import com.moodappinc.streamappa.Assets.Models.Hitbox.HitboxLiveStreams;
import com.moodappinc.streamappa.Assets.RESTHandler;
import com.moodappinc.streamappa.Assets.RESTMethods;
import com.moodappinc.streamappa.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HitboxTab extends Fragment implements CustomRecyclerAdapter.OnRecyclerItemClicker {

    private RecyclerView recyclerView;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private RESTHandler restHandler;
    private List<HitboxLiveStreams.Livestream> topList;

    public HitboxTab() {
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
        View view = inflater.inflate(R.layout.fragment_hitbox_tab, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.hitbox_recycler_view);
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

        RESTMethods restMethods = restHandler.setupRest(getString(R.string.hitbox_api_url)).create(RESTMethods.class);
        restMethods.hitboxGetGames(new Callback<HitboxLiveStreams>() {
            @Override
            public void success(HitboxLiveStreams hitboxLiveStreams, Response response) {
                topList = hitboxLiveStreams.getLivestream();
                customRecyclerAdapter = new CustomRecyclerAdapter(null, topList, null, getActivity());
                recyclerView.setAdapter(customRecyclerAdapter);
                customRecyclerAdapter.setOnRecyclerItemClicker(HitboxTab.this);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAGGERINO", error.getCause().toString());
            }
        });
    }

    @Override
    public void itemClicked(View view, int pos) {

        String channelTitle = topList.get(pos).getMedia_user_name();
        Intent intent = new Intent(getActivity(), StreamPlayerActivity.class);
        intent.putExtra("hitbox_game", getString(R.string.hitbox_api_url)+"player/hls/"+channelTitle+".m3u8");
        intent.putExtra("stream_service_tag", "hitbox");
        getActivity().startActivity(intent);
        Toast.makeText(getActivity(), channelTitle, Toast.LENGTH_LONG).show();
    }
}
