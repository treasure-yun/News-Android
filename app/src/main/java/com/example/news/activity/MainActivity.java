package com.example.news.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import com.example.news.tool.FullScreenVideoView;
import com.example.news.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FullScreenVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView= findViewById(R.id.video_view);
        Button skip= findViewById(R.id.skip);
        skip.setOnClickListener(this);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.movie);
        videoView.setVideoURI(uri);
        MediaController controller = new MediaController(this);
        controller.setVisibility(View.INVISIBLE);
        videoView.setMediaController(controller);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                Intent intent=new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null){
            videoView.suspend();
        }
    }

    public void onClick(View v){
        videoView.suspend();
        Intent intent=new Intent(MainActivity.this,NewsActivity.class);
        startActivity(intent);
    }
}
