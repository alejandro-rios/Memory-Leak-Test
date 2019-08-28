package com.alejandrorios.memoryleaktest

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.atomic.AtomicReference
import kotlin.random.Random

/**
 * Created by alejandrorios on 2019-08-27
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_condor_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        val app = application as ExampleApplication
        val leakedView = findViewById<View>(R.id.helper_text)

        when (Random.nextInt(4)) {
            // Leak from application class
            0 -> {
                Log.i("MainActivity", "Selection number: 0")
                app.leakedViews.add(leakedView)
            }
            // Leak from Kotlin object singleton
            1 -> {
                Log.i("MainActivity", "Selection number: 1")
                LeakingSingleton.leakedViews.add(leakedView)
            }
            2 -> {
                // Leak from local variable on thread
                Log.i("MainActivity", "Selection number: 2")
                val ref = AtomicReference(this)
                val thread = Thread {
                    val activity = ref.get()
                    ref.set(null)
                    while (true) {
                        print(activity)
                        SystemClock.sleep(1000)
                    }
                }
                thread.name = "Leaking local variables"
                thread.start()
            }
            // Leak from thread fields
            else -> {
                Log.i("MainActivity", "Selection number: else")
                LeakingThread.thread.leakedViews.add(leakedView)
            }
        }
    }
}
