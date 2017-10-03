package com.dev.streamify;

import java.util.List;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Serial {

    private String mTitle;
    private List<Episodes> mEpisodes;
    private String mSerialId;
    private int mSerialImage;


    public Serial(String title, List<Episodes> episodes) {
        mTitle = title;
        mEpisodes = episodes;
    }

    public Serial(String title, String id, int imageID) {
        mTitle = title;
        mSerialId = id;
        mSerialImage = imageID;
    }

    public List<Episodes> getmEpisodes() {
        return mEpisodes;
    }

    public String getmSerialId() {
        return mSerialId;
    }

    public String getMtitle() {
        return mTitle;
    }

    public int getmSerialImage() {
        return mSerialImage;
    }
}
