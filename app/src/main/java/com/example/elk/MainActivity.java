package com.example.elk;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class MainActivity extends AppCompatActivity {

    private   KonfettiView konfettiView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konfettiView= findViewById(R.id.viewKonfetti);
        //final KonfettiView viewK=findViewById(R.id.viewK);
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        final Shape.DrawableShape drawableShape = new Shape.DrawableShape(drawable, true);
        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA,Color.RED)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape)
                        .addSizes(new Size(12, 5f))
                        .setPosition( konfettiView.getWidth()/2 , konfettiView.getHeight()/3)
                        //.streamFor(300, 2000L);
                        .burst(100);
            }
        });
        /*
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        }, 4000);

         */

    }



    @Override
    protected void onStart() {
        super.onStart();
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        final Shape.DrawableShape drawableShape = new Shape.DrawableShape(drawable, true);

        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);

    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {


            try{
                String statu=getIntent().getStringExtra("login");
                if(statu.equals("login")){
                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }catch (Exception e){

            }


            return   true;

        }

        return  super.onKeyDown(keyCode, event);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
