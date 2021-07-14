package com.example.elk.ferris_wheel

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elk.R
import kotlinx.android.synthetic.main.ferriswheel_monochrome.*
import ru.github.igla.ferriswheel.CoreStyle

class SampleKotlinActivityMonochrome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ferriswheel_monochrome)
        ferrisWheelView.apply {
            coreStyle = CoreStyle(Color.WHITE, Color.WHITE)
        }
    }
}