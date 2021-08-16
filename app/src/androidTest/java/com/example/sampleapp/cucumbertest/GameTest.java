package com.example.sampleapp.cucumbertest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/androidTest/java/com/example/sampleapp/cucumbertest",glue = {"src/androidTest/java/com/example/sampleapp/cucumbertest"})
public class GameTest {
}
