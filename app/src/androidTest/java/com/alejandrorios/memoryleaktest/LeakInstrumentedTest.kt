package com.alejandrorios.memoryleaktest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

/**
 * Created by alejandrorios on 2019-08-27
 */
class LeakInstrumentedTest {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testIgnoreLeaks() {
        onView(withId(R.id.helper_text)).check(matches(withText(R.string.helper_text)))
    }

    @Test
    @LeakTest
    fun testShowLeaks() {
        onView(withId(R.id.helper_text)).check(matches(withText(R.string.helper_text)))
    }
}
