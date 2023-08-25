package com.tarasov.multistopwatch

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StopwatchService : Service() {

    private val stopwatch1 = StopwatchFlow()


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onCreate() {
        startStopwatch()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

    }


    private fun startStopwatch() {
        CoroutineScope(Dispatchers.Default).launch {
            stopwatch1.start().collect() {
              //  Log.d("MY_LOG", it.toString())
            }
        }
    }

    override fun onDestroy() {
        Log.d("MY_LOG", "сервис уничтожен")
    }

}