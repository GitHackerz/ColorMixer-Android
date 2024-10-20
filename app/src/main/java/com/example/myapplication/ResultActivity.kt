package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ResultLayoutBinding

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ResultLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        if (intent.getStringExtra("result") == "true") {
            // change imageview
            binding.topView.setBackgroundColor(resources.getColor(R.color.green))
            binding.imageView.setImageResource(R.drawable.baseline_done_24)
            binding.resultText.text = "SUCCESS"
            binding.resultTitle.text = "Congratulations $name !"
            binding.resultMessage.text = "Your answer is correct."
            binding.quitButton.setBackgroundColor(resources.getColor(R.color.green))
        } else {
            binding.topView.setBackgroundColor(resources.getColor(R.color.red))
            binding.imageView.setImageResource(R.drawable.baseline_close_24)
            binding.resultText.text = "WRONG"
            binding.resultTitle.text = "Sorry $name !"
            binding.resultMessage.text = "Your answer is wrong."
            binding.quitButton.setBackgroundColor(resources.getColor(R.color.red))
        }


        binding.quitButton.setOnClickListener() {
            // quit application
            finishAndRemoveTask()
        }
    }

}