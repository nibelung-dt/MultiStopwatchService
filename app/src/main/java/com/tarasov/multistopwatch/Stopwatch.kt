package com.tarasov.multistopwatch

import java.util.concurrent.Flow

interface Stopwatch {
    fun start()
    fun pause()
    fun stop()
    fun interval()
    fun reset()
}

    class StopwatchFlow: Stopwatch {
        override fun start() { // : Flow<Long>
            TODO("Not yet implemented")

        }

        override fun pause() {
            TODO("Not yet implemented")
        }

        override fun stop() {
            TODO("Not yet implemented")
        }

        override fun interval() {
            TODO("Not yet implemented")
        }

        override fun reset() {
            TODO("Not yet implemented")
        }

    }