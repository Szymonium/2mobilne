package com.example.carconfigurator

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.view.iterator

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "DiscouragedApi", "SetTextI18n")
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
        val myButton = findViewById<Button>(R.id.send)
        val myImg = findViewById<ImageView>(R.id.car_image)
        val summary = findViewById<TextView>(R.id.summary)
        val checkboxesLayout = findViewById<LinearLayout>(R.id.checkboxes)
        val checkboxes = checkboxesLayout.children as Sequence<CheckBox>
        var radioText = ""

        myRadio.setOnCheckedChangeListener { group, id ->
            radioText = findViewById<RadioButton>(id).text.toString()
            val imgName = radioText.lowercase()

            val img = getDrawable(this.resources.getIdentifier(imgName, "drawable", this.packageName))

            myImg.setImageDrawable(img)
        }

        myButton.setOnClickListener { view ->
            val additions: MutableList<String> = mutableListOf()

            for (checkbox in checkboxes) {
                if (checkbox.isChecked) additions.add(checkbox.text.toString())
            }

            summary.text = "${radioText}\n${additions}"
        }
    }
}