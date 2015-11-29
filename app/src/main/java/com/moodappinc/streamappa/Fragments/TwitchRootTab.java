package com.moodappinc.streamappa.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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


public class TwitchRootTab extends Fragment {

    public TwitchRootTab() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_twitch_root_tab, container, false);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.twitch_root_frame, new TwitchTopGamesTab());
        fragmentTransaction.commit();

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
}
