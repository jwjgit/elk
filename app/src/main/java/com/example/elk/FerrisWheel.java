package com.example.elk;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.github.igla.ferriswheel.FerrisWheelView;

public class FerrisWheel extends AppCompatActivity {
    private FerrisWheelView  ferrisWheelView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferriswheel_main);
        //ferrisWheelView=findViewById(R.id.ferrisWheelView);
       // ferrisWheelView.startAnimation();
        //ferrisWheelView.setRotateDegreeSpeedInSec(20);

    }
}
