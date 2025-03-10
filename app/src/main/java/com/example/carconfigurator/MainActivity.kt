package com.example.carconfigurator

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.iterator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myRadio = findViewById<RadioGroup>(R.id.cars)
        val myImg = findViewById<ImageView>(R.id.car_image)

        for (radioButton in myRadio) {
            if (radioButton.isActivated) {
                myImg.setImageDrawable(Drawable.createFromPath("@drawable/${radioButton.text}"))
            }
        }
    }

    fun send(view: View) {}
}