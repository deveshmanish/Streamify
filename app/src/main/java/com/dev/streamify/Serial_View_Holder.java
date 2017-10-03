package com.dev.streamify;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Serial_View_Holder extends RecyclerView.ViewHolder {

    CardView serial;
    TextView seriesTitle;
    ImageView imageView;

    Serial_View_Holder(View itemView) {
        super(itemView);
        serial = (CardView) itemView.findViewById(R.id.cardView);
        seriesTitle = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.serial_image);
    }

}
