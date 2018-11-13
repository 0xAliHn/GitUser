package com.alihn.gituser.listing;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.alihn.gituser.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UserListingActivityTest
{
    @Rule
    public final ActivityTestRule<UserListingActivity> activityTestRule = new ActivityTestRule<>(UserListingActivity.class);

    @Test
    public void shouldBeAbleToLaunchMainScreen()
    {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldBeAbleToLoadUsers() throws InterruptedException
    {
        Thread.sleep(5000);
        onView(withId(R.id.users_listing)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldBeAbleToScrollViewUserDetails() throws InterruptedException
    {
        Thread.sleep(5000);
        onView(withId(R.id.users_listing)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        Thread.sleep(5000);
        onView(withId(R.id.user_avatar)).check(matches(isDisplayed()));
        onView(withId(R.id.user_name)).check(matches(isDisplayed()));
        onView(withText("Summary")).check(matches(isDisplayed()));
    }
}
