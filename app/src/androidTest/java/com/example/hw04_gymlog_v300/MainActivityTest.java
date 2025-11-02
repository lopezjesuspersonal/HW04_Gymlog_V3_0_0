package com.example.hw04_gymlog_v300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;

import android.os.SystemClock;
import android.util.Log;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    private static final String TEST_USERNAME = "admin1";
    private static final String TEST_PASSWORD = "admin1";
    private static final String EXERCISE_NAME = "OHP";
    private static final String EXERCISE_WEIGHT = "150";
    private static final String EXERCISE_REPS = "5";

    @Test
    public void loginCreateLogTest() {
        // A brief pause to allow the app to fully reset after being cleared.
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        SystemClock.sleep(1000);
        onView(ViewMatchers.withId(R.id.userNameLoginEditText)).perform(typeText(TEST_USERNAME), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.passwordLoginEditText)).perform(typeText(TEST_PASSWORD), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.loginButton)).perform(click());

        SystemClock.sleep(1000);
        onView(withId(R.id.exerciseInputEditText)).perform(typeText(EXERCISE_NAME));
        onView(withId(R.id.weightInputEditText)).perform(typeText(EXERCISE_WEIGHT));
        onView(withId(R.id.repInputEditText)).perform(typeText(EXERCISE_REPS), closeSoftKeyboard());
        onView(withId(R.id.logButton)).perform(click());

        SystemClock.sleep(1000);
        onView(withText(TEST_USERNAME)).perform(click());

        SystemClock.sleep(1000);
        onView(withText("Logout")).perform(click());


        SystemClock.sleep(1000);
        onView(ViewMatchers.withId(R.id.userNameLoginEditText)).perform(typeText(TEST_USERNAME), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.passwordLoginEditText)).perform(typeText(TEST_PASSWORD), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.loginButton)).perform(click());

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        SystemClock.sleep(2000);
        onView(withId(R.id.logDisplayRecyclerView)).check(matches(isDisplayed()));
        onView(withText(containsString(EXERCISE_NAME))).check(matches(isDisplayed()));
        Log.i("EspressoTest", "SUCCESS");
    }
}