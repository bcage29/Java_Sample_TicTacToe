package com.example.sampleapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.widget.TextView;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void playGame() {

    }

    @Test
    public void checkPlayerOneScore() {
        playerOneWinClicks();
        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerOneScore);
        assertTrue(v.getText().equals("1"));
    }

    @Test
    public void checkPlayerTwoScore() {
        playerTwoWinClicks();
        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerTwoScore);
        assertTrue(v.getText().equals("1"));
    }

    @Test
    public void resetGame() {
        playerOneWinClicks();

        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerOneScore);
        assertTrue(v.getText().equals("1"));

        onView(withId(R.id.resetGame)).perform(click());
        assertTrue(v.getText().equals("0"));

    }

    @Test
    public void checkWinningUser() {
        playerOneWinClicks();

        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerStatus);
        assertTrue(v.getText().equals("Player One is Winning!"));

        onView(withId(R.id.resetGame)).perform(click());
        playerTwoWinClicks();

        TextView v2 = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerStatus);
        assertTrue(v2.getText().equals("Player Two is Winning!"));

    }

    public void playerOneWinClicks() {
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_3)).perform(click());
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
    }

    public void playerTwoWinClicks() {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_3)).perform(click());
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
    }


}