package com.example.fitnessapp

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnessapp.databinding.ActivityPedometerBinding

class PedometerActivity : AppCompatActivity(),SensorEventListener {
    lateinit var binding: ActivityPedometerBinding
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    private var initialStepCount: Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPedometerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


    }
    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
       if(sensor==null){
           Toast.makeText(this,"Required Sensors Not Present",Toast.LENGTH_SHORT).show()
       }else{
           sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
       }
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        var data= p0!!.values[0]
        if(initialStepCount==null){
            initialStepCount=data
        }
        val currSessioSteps=data-(initialStepCount?:data)
        Log.d("data","data is ${currSessioSteps}")
        binding.circularProgressBar.apply {
            setProgressWithAnimation(currSessioSteps,1000)
            progressMax=2500f
            progressBarWidth = 7f // in DP
            backgroundProgressBarWidth = 3f // in DP
        }
        binding.textView.text=currSessioSteps.toString()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}