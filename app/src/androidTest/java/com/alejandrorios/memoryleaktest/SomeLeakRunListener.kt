package com.alejandrorios.memoryleaktest

import leakcanary.FailTestOnLeakRunListener
import org.junit.runner.Description

/**
 * Created by alejandrorios on 2019-08-27
 */
class SomeLeakRunListener : FailTestOnLeakRunListener() {
    override fun skipLeakDetectionReason(description: Description): String? {
        return if (description.getAnnotation(LeakTest::class.java) != null)
            null
        else
            "Skip Leak test"
    }
}
