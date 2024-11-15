package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnessapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bmiData.setOnClickListener {
            val intent=Intent(this@MainActivity,BMIActivity::class.java)
            startActivity(intent)
        }
        binding.pedometerimg.setOnClickListener {
            val intent=Intent(this@MainActivity,PedometerActivity::class.java)
            startActivity(intent)
        }

    }
}