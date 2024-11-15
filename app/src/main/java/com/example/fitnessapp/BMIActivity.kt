package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnessapp.databinding.ActivityBmiactivityBinding

class BMIActivity : AppCompatActivity() {
    lateinit var binding: ActivityBmiactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plusHeight.setOnClickListener {
            var height=binding.heightTv.text.toString().toInt()
            height += 1
            binding.heightTv.text=height.toString()
        }
        binding.minusHeight.setOnClickListener {
            var height=binding.heightTv.text.toString().toInt()
            height -= 1
            binding.heightTv.text=height.toString()
        }
        binding.plusWeight.setOnClickListener {
            var weight=binding.weightTv.text.toString().toInt()
            weight += 1
            binding.weightTv.text=weight.toString()
        }
        binding.minusWeight.setOnClickListener {
            var weight=binding.weightTv.text.toString().toInt()
            weight -= 1
            binding.weightTv.text=weight.toString()
        }
        binding.btnBMI.setOnClickListener {
            val h=(binding.heightTv.text.toString().toFloat())/100    //in meters
            val w=binding.weightTv.text.toString().toFloat()
            val bmi=w/(h*h)
            if(bmi<18.5) binding.resultBmi.text="Your BMI is "+bmi.toString()+"\n Underweight BMI"
            else if(bmi in 18.5..25.0) binding.resultBmi.text="Your BMI is "+bmi.toString()+"\n Normal BMI"
            else binding.resultBmi.text="Your BMI is "+bmi.toString()+"\n Overweight BMI"

        }


    }
}