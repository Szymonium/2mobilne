package com.example.coffeecreator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val myImageView: ImageView = findViewById(R.id.imageView)
        val images = listOf(
            R.drawable.espresso,
            R.drawable.capuccino,
            R.drawable.latte
        )
        myImageView.setImageResource(R.drawable.espresso)
        val coffeeGroup: RadioGroup = findViewById(R.id.coffee_radiogroup)

        val rbId = coffeeGroup.getCheckedRadioButtonId()
        when (rbId) {
            R.id.espresso_radiobutton->myImageView.setImageResource(R.drawable.espresso)
            R.id.cappuccino_radiobutton->myImageView.setImageResource(R.drawable.capuccino)
            R.id.latte_radiobutton->myImageView.setImageResource(R.drawable.latte)
        }
    }
}