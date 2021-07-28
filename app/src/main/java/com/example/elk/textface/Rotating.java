package com.example.elk.textface;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.elk.R;
import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;

public class Rotating extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rate_text);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
                Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Reckoner_Bold.ttf");
                RotatingTextWrapper rotatingTextWrapper = (RotatingTextWrapper) findViewById(R.id.custom_switcher);
                rotatingTextWrapper.setSize(35);


                Rotatable rotatable = new Rotatable(Color.parseColor("#FFA036"), 1000, "Word", "Word01", "Word02");
                rotatable.setSize(35);
                rotatable.setAnimationDuration(500);
                rotatingTextWrapper.setContent("This is ?", rotatable);



                RotatingTextWrapper rotatingTextWrapper1 = (RotatingTextWrapper) findViewById(R.id.custom_switcher1);
                rotatingTextWrapper1.setSize(35);
                rotatingTextWrapper1.setTypeface(typeface2);

                Rotatable rotatable1 = new Rotatable(Color.parseColor("#FFA036"), 1000, "Word", "Word01", "Word02");
                rotatable1.setSize(35);
                rotatable1.setAnimationDuration(500);
                rotatable1.setTypeface(typeface);
                rotatable1.setInterpolator(new BounceInterpolator());

                rotatingTextWrapper1.setContent("This is ?", rotatable1);

            }
        });





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
