package com.dev.streamify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Episode_Recycler_View_Adapter extends RecyclerView.Adapter<Episode_View_Holder> {

    List<Episodes> list = Collections.emptyList();
    Context context;

    public Episode_Recycler_View_Adapter(List<Episodes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Episode_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_view, parent, false);
        Episode_View_Holder holder = new Episode_View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Episode_View_Holder holder, int position) {
        holder.episodeTitle.setText(list.get(position).getmEpisodeName());
//        animate(holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    // Insert a new item to the RecyclerView
    public void insert(int position, Episodes episode) {
        list.add(position, episode);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing the Serial object
    public void remove(Episodes data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

//    public void animate(RecyclerView.ViewHolder viewHolder) {
//        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
//        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
//    }

}
