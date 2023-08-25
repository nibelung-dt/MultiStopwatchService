package com.tarasov.multistopwatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarasov.multistopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    val stopwatch1 = StopwatchFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initStartButton()
        initStopButton()
        initResetButton()


       // val stopwatchService = StopwatchService()
        startService(Intent(this, StopwatchService::class.java))


    }

    private fun initStartButton() {
        binding.startButton.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                stopwatch1.start().collect() {
                    withContext(Dispatchers.Main) {
                        binding.timeTextView.text = it.toString()
                    }
                }
            }
        }
    }

    private fun initStopButton() {
        binding.stopButton.setOnClickListener {
            stopwatch1.pause()
        }
    }

    private fun initResetButton() {
        binding.resetButton.setOnClickListener {
            stopwatch1.reset()
        }
    }

}