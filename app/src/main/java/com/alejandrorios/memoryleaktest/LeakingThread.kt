package com.alejandrorios.memoryleaktest

import android.view.View

/**
 * Created by alejandrorios on 2019-08-27
 */
class LeakingThread : Thread() {

    val leakedViews = mutableListOf<View>()

    init {
        name = "Leaking thread"
        start()
    }

    override fun run() {
        synchronized(obj) {
            obj.wait()
        }
    }

    companion object {
        private val obj = Object()
        val thread = LeakingThread()
    }
}
