package com.ni.ta.unideb;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.ni.ta.unideb.stepdef",
    monochrome = true)

public class TestRunner {
  protected static WebDriver driver;
}
