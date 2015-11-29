package com.moodappinc.streamappa.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.moodappinc.streamappa.Assets.Models.Twitch.TokenModel;
import com.moodappinc.streamappa.Assets.RESTHandler;
import com.moodappinc.streamappa.Assets.RESTMethods;
import com.moodappinc.streamappa.R;

import java.io.IOException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StreamPlayerActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer;
    private String channelTitle;

    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_stream_player);

        Intent intent = getIntent();
        tag = intent.getStringExtra("stream_service_tag");

        switch (tag){
            case "twitch":
                channelTitle = intent.getStringExtra("twitch_game");
                break;
            case "hitbox":
                channelTitle = intent.getStringExtra("hitbox_game");
                break;
            default:
                break;
        }


        mediaPlayer = new MediaPlayer();
        final SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceView.setKeepScreenOn(true);

        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mediaPlayer.setDisplay(holder);
            mediaPlayer.setDataSource(channelTitle);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IllegalArgumentException e) {

        } catch (SecurityException e) {

        } catch (IllegalStateException e) {

        } catch (IOException e) {

        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mediaPlayer.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /*if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }*/
    }
}
