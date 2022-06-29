package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private var output: TextView? = null
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age:EditText? = null
    private var generate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        output = findViewById(R.id.tv_output)
        name = findViewById(R.id.et_name)
        height = findViewById(R.id.et_height)
        weight = findViewById(R.id.et_weight)
        age = findViewById(R.id.et_age)
        generate = findViewById(R.id.btn_generation)

        generate?.setOnClickListener {
            onGenerateClick()
        }
    }

    private fun onGenerateClick() {
        val actualName = name?.text.toString()
        val actualHeight = height?.text.toString().toInt()
        val actualWeight = weight?.text.toString().toInt()
        val actualAge = age?.text.toString().toInt()

        if (actualName != "" && actualName.length <= 50 &&
                actualHeight > 0 && actualHeight < 250 &&
                actualWeight > 0 && actualWeight < 250 &&
                actualAge > 0 && actualAge < 150) {
            val magicNumber = abs(actualHeight - actualWeight) * actualAge + actualName.length
            if (magicNumber < 100)
                output?.text = "У вас ипотека"
            else if (magicNumber in 101..999)
                output?.text = "Вы овен"
            else
                output?.text = "ладно."
            }
        else
            output?.text = "Данные введены некорректно."
    }
}