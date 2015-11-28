package com.moodappinc.streamappa.Assets;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moodappinc.streamappa.Assets.Models.Hitbox.HitboxLiveStreams;
import com.moodappinc.streamappa.Assets.Models.Twitch.GamesModel;
import com.moodappinc.streamappa.Assets.Models.Twitch.TopChannelsModel;
import com.moodappinc.streamappa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private List<TopChannelsModel.Top> twitchTopList;
    private List<HitboxLiveStreams.Livestream> hitboxLiveStreams;
    private List<GamesModel.Streams> twitchGamesModels;

    private OnRecyclerItemClicker onRecyclerItemClicker;

    private Context context;

    public CustomRecyclerAdapter(List<TopChannelsModel.Top> topList, List<HitboxLiveStreams.Livestream> hitboxLiveStreams, List<GamesModel.Streams> gamesModels, Context context) {
        this.twitchTopList = topList;
        this.hitboxLiveStreams = hitboxLiveStreams;
        this.twitchGamesModels = gamesModels;
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
        } else if (hitboxLiveStreams != null) {
            HitboxLiveStreams.Livestream livestream = hitboxLiveStreams.get(position);
            Picasso.with(context)
                    .load(context.getString(R.string.hitbox_resource_url) + livestream.getMedia_thumbnail_large())
                    .fit()
                    .into(holder.thumbnail);
        } else {
            GamesModel.Streams streams = twitchGamesModels.get(position);
            Picasso.with(context)
                    .load(Uri.parse(streams.getPreview().getLarge()))
                    .fit()
                    .into(holder.thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        if (hitboxLiveStreams != null) return hitboxLiveStreams.size();
        else if (twitchTopList != null) return twitchTopList.size();
        else return twitchGamesModels.size();
    }

    public void setOnRecyclerItemClicker(OnRecyclerItemClicker onRecyclerItemClicker) {
        this.onRecyclerItemClicker = onRecyclerItemClicker;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context context;
        private ImageView thumbnail;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            itemView.setOnClickListener(this);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (onRecyclerItemClicker != null) {
                onRecyclerItemClicker.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public interface OnRecyclerItemClicker {
        void itemClicked(View view, int pos);
    }
}
