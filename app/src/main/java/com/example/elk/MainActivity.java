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
import android.widget.Toast;

import com.example.elk.ferris_wheel.SampleKotlinActivity;
import com.example.elk.ferris_wheel.SampleKotlinActivityMonochrome;
import com.example.elk.textface.Rotating;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Eases.EaseType;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.ClickEffectType;
import com.nightonke.boommenu.Types.DimType;
import com.nightonke.boommenu.Types.OrderType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private   KonfettiView konfettiView;
    private BoomMenuButton boomMenuButton;
    private int[][] subButtonColors=new int[][]{{Color.RED,Color.parseColor("#00BFFF")},{Color.RED,Color.GREEN},{Color.RED,Color.parseColor("#DAA520")},{Color.RED,Color.parseColor("#DA70D6")}};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konfettiView= findViewById(R.id.viewKonfetti);
        boomMenuButton = (BoomMenuButton)findViewById(R.id.boom);
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
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // this is an example to show how to use the builder
        new BoomMenuButton.Builder()
                // set all sub buttons with subButtons method
                //.subButtons(subButtonDrawables, subButtonColors, subButtonTexts)
                // or add each sub button with addSubButton method
                .addSubButton(this, R.drawable.bear, subButtonColors[0], "ferris wheel")
                .addSubButton(this, R.drawable.deer1, subButtonColors[1], "music")
                .addSubButton(this, R.drawable.squirrel, subButtonColors[2], "poems")
                .addSubButton(this,R.drawable.bee,subButtonColors[3],"login")
                .frames(80)
                .duration(800)
                .delay(100)
                .showOrder(OrderType.RANDOM)
                .hideOrder(OrderType.RANDOM)
                .button(ButtonType.CIRCLE)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.CIRCLE_4_2)
                .showMoveEase(EaseType.EaseOutBack)
                .hideMoveEase(EaseType.EaseOutCirc)
                .showScaleEase(EaseType.EaseOutBack)
                .hideScaleType(EaseType.EaseOutCirc)
                .rotateDegree(720)
                .showRotateEase(EaseType.EaseOutBack)
                .hideRotateType(EaseType.Linear)
                .autoDismiss(true)
                .cancelable(true)
                .dim(DimType.DIM_6)
                .clickEffect(ClickEffectType.RIPPLE)
                .boomButtonShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .subButtonTextColor(Color.BLACK)
                //.onBoomButtonBlick()
                .animator(null)
                //.onSubButtonClick(null)
                .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                    @Override
                    public void onClick(int buttonIndex) {
                        if(buttonIndex==0){
                            //Toast.makeText(MainActivity.this,"1",Toast.LENGTH_LONG).show();
                            //startActivity(SampleKotlinActivity.class);
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    startActivity(SampleKotlinActivity.class);
                                }
                            }, 700);

                        }
                        if(buttonIndex==1){
                            //Toast.makeText(MainActivity.this,"2",Toast.LENGTH_LONG).show();
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    startActivity(MusicPlay.class);
                                }
                            }, 720);

                        }
                        if(buttonIndex==2){
                            //Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    startActivity(TextSurfer.class);
                                    // startActivity(Rotating.class);
                                }
                            }, 700);

                        }
                        if(buttonIndex==3){
                            //Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    startActivity(Login.class);
                                }
                            }, 700);

                        }

                    }
                })
                // this only work when the place type is SHARE_X_X
                .shareStyle(0, 0, 0)
                .init(boomMenuButton);
    }
    private void listenClickEventOf(int id) {
        findViewById(id).setOnClickListener(this);
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {


            try{
                String statu=getIntent().getStringExtra("login");
                if(statu.equals("login")){
                    //Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    //startActivity(intent);
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

    @Override
    public void onClick(View v) {

    }
}
