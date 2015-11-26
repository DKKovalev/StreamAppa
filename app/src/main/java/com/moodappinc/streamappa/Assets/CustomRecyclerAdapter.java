package com.moodappinc.streamappa.Assets;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moodappinc.streamappa.Assets.Models.Hitbox.GamesModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TopChannelsModel;
import com.moodappinc.streamappa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private List<TopChannelsModel.Top> twitchTopList;
    private List<GamesModel.Categories> hitboxGamesList;

    private Context context;

    public CustomRecyclerAdapter(List<TopChannelsModel.Top> topList, List<GamesModel.Categories> hitboxGamesList, Context context) {
        this.twitchTopList = topList;
        this.hitboxGamesList = hitboxGamesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, null);
        ViewHolder viewHolder = new ViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (twitchTopList != null) {
            TopChannelsModel.Top top = twitchTopList.get(position);
            Picasso.with(context)
                    .load(Uri.parse(top.getGame().getBox().getLarge()))
                    .fit()
                    .into(holder.thumbnail);
        } else {
            GamesModel.Categories categories = hitboxGamesList.get(position);
            Picasso.with(context)
                    .load(context.getString(R.string.hitbox_resource_url) + categories.getCategory_logo_large())
                    .fit()
                    .into(holder.thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        if (hitboxGamesList != null) {
            return hitboxGamesList.size();
        } else return twitchTopList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context context;
        private ImageView thumbnail;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.context = context;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
