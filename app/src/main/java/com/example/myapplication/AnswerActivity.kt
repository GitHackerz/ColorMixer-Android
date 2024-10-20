package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.AnswerLayoutBinding

class AnswerActivity : AppCompatActivity() {

    private lateinit var binding: AnswerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnswerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val color1 = intent.getStringExtra("color1")
        val color2 = intent.getStringExtra("color2")
        val mixedColor = intent.getStringExtra("mixedColor")
        val name = intent.getStringExtra("name")

        binding.answerText.text =
            "You choosed $color1 and $color2"

        binding.submitButton.setOnClickListener() {
            var result = false
            if (binding.orange.isChecked && mixedColor == ORANGE) {
                result = true
            } else if (binding.purple.isChecked && mixedColor == PURPLE) {
                result = true
            }
            else if (binding.green.isChecked && mixedColor == GREEN) {
                result = true
            }

            intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("result", result.toString())
                putExtra("name", name)
            }

            startActivity(intent)
        }
    }
}