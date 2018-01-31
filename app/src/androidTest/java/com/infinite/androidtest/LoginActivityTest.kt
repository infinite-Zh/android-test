package com.infinite.androidtest

import android.support.design.widget.Snackbar
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.MediumTest
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

    @Test
    fun buttonShow(){
        onView(withId(R.id.email_sign_in_button)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithEmptyEmailShouldShowError(){
        onView(withId(R.id.email)).perform(typeText(""))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.email_empty)).check(matches(isDisplayed()))
    }
    @Test
    fun loginWithEmptPasswordShouldShowError(){
        onView(withId(R.id.email)).perform(typeText("zhang.x2005@163.com"))
        onView(withId(R.id.password)).perform(typeText(""))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.password_empty)).check(matches(isDisplayed()))
    }

}
