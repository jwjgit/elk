package com.example.elk;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elk.textface.AlignSample;
import com.example.elk.textface.AvailableSample;
import com.example.elk.textface.ColorSample;
import com.example.elk.textface.CookieThumperSample;
import com.example.elk.textface.FactCookie;
import com.example.elk.textface.Rotation3DSample;
import com.example.elk.textface.ScaleTextSample;
import com.example.elk.textface.ShapeRevealLoopSample;
import com.example.elk.textface.ShapeRevealSample;
import com.example.elk.textface.SlideSample;
import com.example.elk.textface.SurfaceScaleSample;
import com.example.elk.textface.SurfaceTransSample;

import java.io.IOException;

import su.levenetc.android.textsurface.TextSurface;

public class TextSurfer extends AppCompatActivity {

    private TextSurface textSurface;
    private MediaPlayer mediaPlayer=new MediaPlayer();


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        textSurface = (TextSurface) findViewById(R.id.text_surface);
        /*
        try {
            initMediaPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        textSurface.postDelayed(new Runnable() {
            @Override public void run() {
                show();
               // ShapeRevealLoopSample.play(textSurface);
            }
        }, 1000);





    }

    private void show() {
        textSurface.reset();
        //AvailableSample.play();
        FactCookie.play(textSurface,getAssets());
    }

    private void initMediaPlayer() throws IOException {
        AssetManager assetManager=getAssets();
        AssetFileDescriptor fd=assetManager.openFd("lonely.mp3");

          //AssetFileDescriptor fd=assetManager.openFd("birthday_song.m4a");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mediaPlayer.setDataSource(fd);
        }
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
