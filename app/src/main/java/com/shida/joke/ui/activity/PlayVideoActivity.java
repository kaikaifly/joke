package com.shida.joke.ui.activity;

import android.os.Bundle;

import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;

import butterknife.Bind;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
public class PlayVideoActivity extends BaseActivity {
    @Bind(R.id.surface_view)
    VideoView surfaceView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_playvideo;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Vitamio.isInitialized(context);
        VideoView mVideoView;
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(getIntent().getStringExtra("videoPath"));
        mVideoView.setMediaController(new MediaController(context));
        mVideoView.requestFocus();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }


}
