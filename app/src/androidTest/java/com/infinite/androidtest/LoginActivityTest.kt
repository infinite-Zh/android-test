package com.infinite.androidtest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by kfzhangxu on 2018/1/31.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    public val rule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun performLogin() {
//        R.id.email perform typeText("")
        onView(withId(R.id.email)).perform(typeText("abcdefghijklmnopqrstuvwxyz"))
        onView(withId(R.id.email)).check(matches(withText("abcdefghijklmnopqrstuvwxyz")))
    }

}
