package com.example.td3_videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.video)
    VideoView videoPlayer;

    @BindView(R.id.play_video_button)
    ImageButton playVideoButton;

    @BindView(R.id.pause_video_button)
    ImageButton pauseVideoButton;

    @BindView(R.id.exit_button)
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aeon_flux);
        videoPlayer.setVideoURI(path);

        exitButton.setOnClickListener(new ExitApplication());

        playVideoButton.setOnClickListener(new PlayVideo());
        pauseVideoButton.setOnClickListener(new PauseVideo());
    }

    private class ExitApplication implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            videoPlayer.stopPlayback();
            finish();
        }
    }

    private class PlayVideo implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            videoPlayer.start();
        }
    }

    private class PauseVideo implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            videoPlayer.pause();
        }
    }
}
