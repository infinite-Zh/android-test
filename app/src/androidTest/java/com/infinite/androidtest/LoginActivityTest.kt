package com.infinite.androidtest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.infinite.androidtest.repository.LoginDataSource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

/**
 * Created by kfzhangxu on 2018/1/31.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Test
    fun performLogin() {
        onView(withId(R.id.email)).perform(typeText("abcdefghijklmnopqrstuvwxyz"))
        onView(withId(R.id.email)).check(matches(withText("abcdefghijklmnopqrstuvwxyz")))
    }

    @Test
    fun buttonShow() {
        onView(withId(R.id.email_sign_in_button)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithEmptyEmailShouldShowError() {
        onView(withId(R.id.email)).perform(typeText(""))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.email_empty)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithEmptPasswordShouldShowError() {
        onView(withId(R.id.email)).perform(typeText("abcd@"))
        onView(withId(R.id.password)).perform(typeText(""))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.password_empty)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithWrongEmailFormatShouldShowError() {
        onView(withId(R.id.email)).perform(typeText("abcd"))
        onView(withId(R.id.password)).perform(typeText("132456"))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.email_illegal)).check(matches(isDisplayed()))
    }
    @Test
    fun loginWithWrongEmailShouldShowError() {
        onView(withId(R.id.email)).perform(typeText("abcd@"))
        onView(withId(R.id.password)).perform(typeText("132456"))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText("用户名错误")).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithWrongPasswordShouldShowError() {
        onView(withId(R.id.email)).perform(typeText("abc@163.com"))
        onView(withId(R.id.password)).perform(typeText("132456"))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText("密码错误")).check(matches(isDisplayed()))
    }

    @Test
    fun loginSuccess() {
        onView(withId(R.id.email)).perform(typeText("abc@163.com"))
        onView(withId(R.id.password)).perform(typeText("123abc"))
        onView(withId(R.id.email_sign_in_button)).perform(click())
        onView(withText(R.string.hello)).check(matches(isDisplayed()))
    }
}
