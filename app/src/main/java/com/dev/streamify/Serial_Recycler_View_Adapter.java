package com.dev.streamify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Collections;
import java.util.List;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Serial_Recycler_View_Adapter extends RecyclerView.Adapter<Serial_View_Holder> {

    List<Serial> list = Collections.emptyList();
    Context context;

    public Serial_Recycler_View_Adapter(List<Serial> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Serial_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        Serial_View_Holder holder = new Serial_View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Serial_View_Holder holder, int position) {
        holder.seriesTitle.setText(list.get(position).getMtitle());
        RequestOptions options = new RequestOptions().centerCrop();
        switch (list.get(position).getmSerialImage()) {

            case 2130837588:
                Glide.with(context).load(R.drawable.thewire).apply(options).into(holder.imageView);
                break;
            case 2130837583:
                Glide.with(context).load(R.drawable.legion).apply(options).into(holder.imageView);
                break;
            case 2130837585:
                Glide.with(context).load(R.drawable.rickandmorty).apply(options).into(holder.imageView);
                break;
            case 2130837575:
                Glide.with(context).load(R.drawable.billions).apply(options).into(holder.imageView);
                break;
            case 2130837584:
                Glide.with(context).load(R.drawable.narcos).apply(options).into(holder.imageView);
                break;
            case 2130837573:
                Glide.with(context).load(R.drawable.bandofbrothers).apply(options).into(holder.imageView);
                break;
            case 2130837590:
                Glide.with(context).load(R.drawable.westworld).apply(options).into(holder.imageView);
                break;
            case 2130837587:
                Glide.with(context).load(R.drawable.thebigbangtheory).apply(options).into(holder.imageView);
                break;
            case 2130837582:
                Glide.with(context).load(R.drawable.haltandcatchfire).apply(options).into(holder.imageView);
                break;
            case 2130837581:
                Glide.with(context).load(R.drawable.fullmetalalchemistbrotherhood).apply(options).into(holder.imageView);
                break;
            case 2130837577:
                Glide.with(context).load(R.drawable.breakingbad).apply(options).into(holder.imageView);
                break;
            case 2130837576:
                Glide.with(context).load(R.drawable.blackmirror).apply(options).into(holder.imageView);
                break;
            case 2130837580:
                Glide.with(context).load(R.drawable.friends).apply(options).into(holder.imageView);
                break;
            case 2130837574:
                Glide.with(context).load(R.drawable.bettercallsaul).apply(options).into(holder.imageView);
                break;
            default:
                Glide.with(context).load(R.drawable.thewire).apply(options).into(holder.imageView);

        }
//        holder.imageView.setImageResource(list.get(position).getmSerialImage());
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
    public void insert(int position, Serial serial) {
        list.add(position, serial);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing the Serial object
    public void remove(Serial serial) {
        int position = list.indexOf(serial);
        list.remove(position);
        notifyItemRemoved(position);
    }

    //    public void animate(RecyclerView.ViewHolder viewHolder) {
//        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
//        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
//    }
    public List<Serial> getList() {
        return this.list;
    }


}
