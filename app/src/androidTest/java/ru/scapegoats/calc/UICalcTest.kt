package ru.scapegoats.calc

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UICalcTest {


    @get:Rule
    val mActivityRule: ActivityTestRule<Calc> = ActivityTestRule(Calc::class.java)


    @Test
    fun clickOnNumButton_displayedOnAScreen(){
        onView(withId(R.id.b1)).perform(click())
        onView(withId(R.id.display)).check(matches(isDisplayed()))
    }

}