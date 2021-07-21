package com.example.elk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elk.textface.AlignSample;
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

import su.levenetc.android.textsurface.TextSurface;

public class TextSurfer extends AppCompatActivity {

    private TextSurface textSurface;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        textSurface = (TextSurface) findViewById(R.id.text_surface);

        textSurface.postDelayed(new Runnable() {
            @Override public void run() {
                show();
                //ShapeRevealLoopSample.play(textSurface);
            }
        }, 1000);





    }

    private void show() {
        textSurface.reset();
        FactCookie.play(textSurface,getAssets());
    }




}
