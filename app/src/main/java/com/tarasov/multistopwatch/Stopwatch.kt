package com.tarasov.multistopwatch

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

//interface Stopwatch {
//    suspend fun start() = flow<Long>()
//
//    fun pause()
//    fun stop()
//    fun interval()
//    fun reset()
//}

    class StopwatchFlow {

        private var seconds: Long = 0
        private var isStart = true
        suspend fun start() = flow  {
            isStart = true
            while(isStart) {
                seconds++
                Log.d("MY_LOG", seconds.toString())
                delay(1000)
                emit(seconds)
            }
        }


        fun pause() {
            isStart = false
        }

        fun reset() {
            seconds = 0
            isStart = false
        }

//        fun stop() {
//            TODO("Not yet implemented")
//        }

        fun interval() {
            TODO("Not yet implemented")
        }



    }