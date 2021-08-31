package com.example.pinchgesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import kotlin.math.min
import kotlin.properties.Delegates

lateinit var beachImage: ImageView
var scale = 1f

class MainActivity : AppCompatActivity() {
    var scaleDetector : ScaleGestureDetector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beachImage = findViewById(R.id.beachImg)
        scaleDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale, 5.0f))
            beachImage.scaleX = scale
            beachImage.scaleY = scale

            return true
        }
    }
}