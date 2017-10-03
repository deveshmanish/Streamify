package com.dev.streamify;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Episode_View_Holder extends RecyclerView.ViewHolder {
    CardView episodeCardView;
    TextView episodeTitle;

    Episode_View_Holder(View itemView) {
        super(itemView);
        episodeCardView = (CardView) itemView.findViewById(R.id.episode_cardView);
        episodeTitle = (TextView) itemView.findViewById(R.id.episode_textview);
    }
}