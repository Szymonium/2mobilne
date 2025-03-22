package com.example.coffeecreator

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coffeeImage: ImageView = findViewById(R.id.coffeeImage)
        val espressoRadio: RadioButton = findViewById(R.id.radio_espresso)
        val cappuccinoRadio: RadioButton = findViewById(R.id.radio_cappuccino)
        val latteRadio: RadioButton = findViewById(R.id.radio_latte)
        val milkCheckBox: CheckBox = findViewById(R.id.checkbox_milk)
        val sugarCheckBox: CheckBox = findViewById(R.id.checkbox_sugar)
        val quantitySeekBar: SeekBar = findViewById(R.id.seekbar_quantity)
        val quantityText: TextView = findViewById(R.id.text_quantity)
        val orderButton: Button = findViewById(R.id.button_order)

        val coffeeSelectionListener = RadioGroup.OnCheckedChangeListener { _, _ ->
            when {
                espressoRadio.isChecked -> coffeeImage.setImageResource(R.drawable.espresso)
                cappuccinoRadio.isChecked -> coffeeImage.setImageResource(R.drawable.cappuccino)
                latteRadio.isChecked -> coffeeImage.setImageResource(R.drawable.latte)
            }
        }
        findViewById<RadioGroup>(R.id.radio_group).setOnCheckedChangeListener(coffeeSelectionListener)

        quantitySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                quantityText.text = "Ilosc: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        orderButton.setOnClickListener {
            val selectedCoffee = when {
                espressoRadio.isChecked -> "Espresso"
                cappuccinoRadio.isChecked -> "Cappuccino"
                latteRadio.isChecked -> "Latte"
                else -> "Wybierz kawe."
            }
            val milk = if (milkCheckBox.isChecked) "z mlekiem" else "bez mleka"
            val sugar = if (sugarCheckBox.isChecked) "z cukrem" else "bez cukru"
            val quantity = quantitySeekBar.progress

            val orderSummary = "Zamowiono: $quantity sztuk $selectedCoffee, $milk, $sugar."
            Toast.makeText(this, orderSummary, Toast.LENGTH_LONG).show()
        }
    }
}
