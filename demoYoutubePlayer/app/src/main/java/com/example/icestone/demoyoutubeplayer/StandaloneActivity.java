package com.example.icestone.demoyoutubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
        implements View.OnClickListener {
    private String GOOGLE_API_KEY = "AIzaSyBtsHhziXG1v6FbjGZejlt9T-sPadHOjYA";
    private String YOUTUBE_VIDEO_ID = "gCISR0T3grE";
    private String YOUTUBE_PLAYLIST = "PLj_Goi54wf0fQPWB_hjgmd3i1yIXeLXHI";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if (intent != null){
            startActivity(intent);
        }

    }
}
