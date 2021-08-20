package com.example.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertTrue;

import androidx.test.rule.ActivityTestRule;

import com.example.sampleapp.MainActivity;
import com.example.sampleapp.R;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

public class GameSteps {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    private MainActivity main;
    private Activity activity;


    @Before("@play-game-feature")
    public void setup() {
        mActivityTestRule.launchActivity(new Intent());
        activity = mActivityTestRule.getActivity();
    }

    @After("@play-game-feature")
    public void tearDown() {
        mActivityTestRule.finishActivity();
        reportHelper.label("Stopping App");
    }

    @Given("check winning user")
    public void check_winning_user() {
        playerOneWinClicks();

        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerStatus);
        assertTrue(v.getText().equals("Player One is Winning!"));

        onView(withId(R.id.resetGame)).perform(click());
        playerTwoWinClicks();

        TextView v2 = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerStatus);
        assertTrue(v2.getText().equals("Player Two is Winning!"));

    }

    @Given("check player one score")
    public void check_player_one_score() {
        playerOneWinClicks();
        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerOneScore);
        assertTrue(v.getText().equals("1"));
    }

    @Given("check player two score")
    public void check_player_two_score() {
        playerOneWinClicks();
        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerOneScore);
        assertTrue(v.getText().equals("1"));
    }

    @Given("reset game")
    public void reset_game() {
        playerOneWinClicks();

        TextView v = (TextView) mActivityTestRule.getActivity().findViewById(R.id.playerOneScore);
        assertTrue(v.getText().equals("1"));

        onView(withId(R.id.resetGame)).perform(click());
        assertTrue(v.getText().equals("0"));
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
