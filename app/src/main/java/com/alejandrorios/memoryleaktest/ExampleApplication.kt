package com.alejandrorios.memoryleaktest

import android.app.Application
import android.view.View

/**
 * Created by alejandrorios on 2019-08-27
 */
open class ExampleApplication : Application() {
    val leakedViews = mutableListOf<View>()

    override fun onCreate() {
        super.onCreate()
    }
}
