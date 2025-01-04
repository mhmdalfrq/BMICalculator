package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight: EditText = findViewById(R.id.etWeight)
        val etHeight: EditText = findViewById(R.id.etHeight)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val weight = etWeight.text.toString().toFloatOrNull()
            val height = etHeight.text.toString().toFloatOrNull()

            if (weight == null || height == null) {
                tvResult.text = "Masukkan nilai berat dan tinggi yang valid"
                return@setOnClickListener
            }

            val heightInMeters = height / 100
            val bmi = weight / (heightInMeters * heightInMeters)

            val bmiCategory = when {
                bmi < 18.5 -> "Kekurangan Berat Badan"
                bmi in 18.5..24.9 -> "Normal"
                bmi in 25.0..29.9 -> "Kelebihan Berat Badan"
                else -> "Obesitas"
            }

            tvResult.text = "BMI Anda: %.2f (%s)".format(bmi, bmiCategory)
        }
    }
}
