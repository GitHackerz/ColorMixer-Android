package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.QuestionLayoutBinding

const val RED = "Red"
const val YELLOW = "Yellow"
const val BLUE = "Blue"

const val ORANGE = "Orange"
const val GREEN = "Green"
const val PURPLE = "Purple"

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: QuestionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = QuestionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.mixButton.setOnClickListener { onMixBtnClick() }

    }

    fun onMixBtnClick() {
        val selectedColors = mutableListOf<String>()

        if (binding.nameInput.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.red.isChecked)
            selectedColors.add(RED)
        if (binding.yellow.isChecked)
            selectedColors.add(YELLOW)
        if (binding.blue.isChecked)
            selectedColors.add(BLUE)

        if (selectedColors.size < 2)
            Toast.makeText(this, "Please select at least 2 colors", Toast.LENGTH_SHORT).show()

        if (selectedColors.size >= 2) {
            val color1 = selectedColors[0]
            val color2 = selectedColors[1]
            val mixedColor = mixColors(color1, color2)
            Toast.makeText(this, "Mixed color is $mixedColor", Toast.LENGTH_SHORT).show()

            // navigate to next screen
            val intent = Intent(this, AnswerActivity::class.java).apply {
                putExtra("name", binding.nameInput.text.toString())
                putExtra("color1", color1)
                putExtra("color2", color2)
                putExtra("mixedColor", mixedColor)
            }

            startActivity(intent)
        }

    }

    fun mixColors(color1: String, color2: String): String {
        if (color1 == RED && color2 == YELLOW || color1 == YELLOW && color2 == RED) {
            return ORANGE
        } else if (color1 == YELLOW && color2 == BLUE || color1 == BLUE && color2 == YELLOW) {
            return GREEN
        } else if (color1 == BLUE && color2 == RED || color1 == RED && color2 == BLUE) {
            return PURPLE
        }

        return ""
    }
}