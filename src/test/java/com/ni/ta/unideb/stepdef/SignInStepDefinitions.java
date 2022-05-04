package com.ni.ta.unideb.stepdef;

import com.ni.ta.unideb.TestRunner;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class SignInStepDefinitions extends TestRunner {

    @When("the Sign in header button is clicked")
    public void theSignInHeaderButtonIsClicked() {
        final var signInButton = driver.findElement(By.cssSelector("a[href*='https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin']"));
        signInButton.click();
    }
}
