package com.ni.ta.unideb.stepdef;

import com.ni.ta.unideb.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpStepDefinitions extends TestRunner {

    @Given("the sign up page is opened")
    public void theSignUpPageIsOpened() {
        driver.get("https://www.linkedin.com/signup");
    }

    @When("the {} button is clicked")
    public void theButtonIsClickedWith(final String buttonText) {
        final var signInButton = driver.findElement(By.xpath(String.format("//button[text()=%s]", buttonText)));
        signInButton.click();
    }

    @Then("under the email field, a validation error message is appeared with {}")
    public void underTheEmailFieldAValidationErrorMessageIsAppearedWithPleaseEnterYourEmailAddress(final String expectedErrorMessage) {
        validateEmailFieldErrorMessage(expectedErrorMessage);
    }

    @Then("under the password field, a validation error message is appeared with {}")
    public void underThePasswordFieldAValidationErrorMessageIsAppearedWithPleaseEnterYourPassword(final String expectedErrorMessage) {
        validatePasswordErrorMessage(expectedErrorMessage);
    }

    @When("the {} field with the {} id is filled in with {}")
    public void theFieldFieldWithTheIdIdIsFilledInWithParameter(final String fieldName, final String inputId, final String inputData) {
        final var inputField = driver.findElement(By.xpath(String.format("//input[@id=%s]", inputId)));
        inputField.sendKeys(inputData);
    }

    @And("the tab button is pressed in the previous field with {}")
    public void theTabButtonIsPressedInThePreviousFieldWithId(final String inputId) {
        final var inputField = driver.findElement(By.xpath(String.format("//input[@id=%s]", inputId)));
        inputField.sendKeys(Keys.TAB);
    }

    @Then("under the {} field, a {} is appeared")
    public void underTheFieldFieldFieldAValidationErrorMessageIsAppeared(final String inputId, final String expectedErrorMessage) {
        switch (inputId) {
            case "'email'": validateEmailFieldErrorMessage(expectedErrorMessage);
            break;
            case "'password'": validatePasswordErrorMessage(expectedErrorMessage);
            break;
            default:
                throw new IllegalArgumentException(inputId + " is not found");
        }
    }

    private String findErrorMessageForEmailValidationFailure() {
        return driver.findElement(By.xpath("//div[@class='join-form__form-input-container join-form__form-input-container--is-section-1']//div[@class='inline-alert artdeco-inline-feedback artdeco-inline-feedback--error']/p")).getText();
    }

    private String findErrorMessageForPasswordValidationFailure() {
        return driver.findElement(By.xpath("//div[@class='join-form__show-password-container']//div[@class='inline-alert artdeco-inline-feedback artdeco-inline-feedback--error']/p")).getText();
    }

    private void validateEmailFieldErrorMessage(final String expectedErrorMessage) {
        final var actualErrorMessage = findErrorMessageForEmailValidationFailure();
        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));
    }

    private void validatePasswordErrorMessage(final String expectedErrorMessage) {
        final var actualErrorMessage = findErrorMessageForPasswordValidationFailure();
        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));
    }
}
