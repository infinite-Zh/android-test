package com.infinite.androidtest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by kfzhangxu on 2018/2/24.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun scrollToLast() {
        onView(withId(R.id.text_last)).perform(scrollTo()).check(matches(isDisplayed()))
    }
    @Test
    fun inputLastEidtText() {
        onView(withId(R.id.edit_last)).perform(scrollTo(), typeText("abcdefghijklmnopqrst"))
    }
}