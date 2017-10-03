package com.dev.streamify;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class Episodes {

    private String mEpisodeName;
    private String mEpisodeUrl;

    Episodes(String episodeName, String episodeUrl) {
        mEpisodeName = episodeName;
        mEpisodeUrl = episodeUrl;
    }

    public String getmEpisodeUrl() {
        return mEpisodeUrl;
    }

    public String getmEpisodeName() {
        return mEpisodeName;
    }
}


