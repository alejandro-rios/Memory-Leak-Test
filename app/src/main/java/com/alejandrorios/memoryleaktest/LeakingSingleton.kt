package com.alejandrorios.memoryleaktest

import android.view.View

/**
 * Created by alejandrorios on 2019-08-27
 */
object LeakingSingleton {
    val leakedViews = mutableListOf<View>()
}
