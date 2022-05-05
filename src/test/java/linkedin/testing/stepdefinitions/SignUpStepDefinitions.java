package linkedin.testing.stepdefinitions;

import linkedin.testing.factory.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static linkedin.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpStepDefinitions {

    @Autowired
    private WebDriverFactory factory;

    @Given("the sign up page is opened")
    public void theSignUpPageIsOpened() {
        var driver = factory.getWebDriver();
        driver.get("https://www.linkedin.com/signup");
    }

    @When("the 'Agree & Join' button is clicked")
    public void the_button_is_clicked() {
        var driver = factory.getWebDriver();
        var signUpButton = driver.findElement(By.cssSelector("#join-form-submit"));
        signUpButton.click();

    }


    @Then("under the email field, a validation error message is appeared with {} message or with {} message")
    public void underTheEmailFieldAValidationErrorMessageIsAppearedWithPleaseEnterYourEmailAddress(final String firstErrorMessage, final String secondaryErrorMessage) {
        validateEmailFieldErrorMessage(firstErrorMessage, secondaryErrorMessage);
    }

    @Then("under the password field, a validation error message is appeared with {}")
    public void underThePasswordFieldAValidationErrorMessageIsAppearedWithPleaseEnterYourPassword(final String expectedErrorMessage) {
        validatePasswordErrorMessage(expectedErrorMessage);
    }

    @When("the {} field with the {} id or with the {} id is filled in with {}")
    public void theFieldFieldWithTheIdIdIsFilledInWithParameter(final String fieldName, final String inputId, final String secondaryId, final String inputData) {
        var driver = factory.getWebDriver();
        //WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[@id=%s]", inputId))));
        final var inputField =  findInputField(driver, inputId, secondaryId);
        inputField.sendKeys(inputData);
    }

    @And("the tab button is pressed in the previous field with {} id or with {} id")
    public void theTabButtonIsPressedInThePreviousFieldWithId(final String inputId, final  String secondaryId) {
        var driver = factory.getWebDriver();
        final var inputField = findInputField(driver, inputId, secondaryId);
        inputField.sendKeys(Keys.TAB);
    }

    @Then("under the {} field, the {} is appeared or {} is appeared")
    public void underTheFieldFieldFieldAValidationErrorMessageIsAppeared(final String inputId, final String firstExpectedErrorMessage, final String secondExpectedErrorMessage) {
        switch (inputId) {
            case "'email'": validateEmailFieldErrorMessage(firstExpectedErrorMessage, secondExpectedErrorMessage);
            break;
            case "'password'": validatePasswordErrorMessage(firstExpectedErrorMessage);
            break;
            default:
                throw new IllegalArgumentException(inputId + " is not found");
        }
    }

    private String findErrorMessageForEmailValidationFailure() {
        var driver = factory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='join-form__form-input-container join-form__form-input-container--is-section-1']//div[@class='inline-alert artdeco-inline-feedback artdeco-inline-feedback--error']/p")));
        return driver.findElement(By.xpath("//div[@class='join-form__form-input-container join-form__form-input-container--is-section-1']//div[@class='inline-alert artdeco-inline-feedback artdeco-inline-feedback--error']/p")).getText();
    }

    private String findErrorMessageForPasswordValidationFailure() {
        var driver = factory.getWebDriver();
        waitForPageReadiness();
        return driver.findElement(By.xpath("//div[@class='join-form__show-password-container']//div[@class='inline-alert artdeco-inline-feedback artdeco-inline-feedback--error']/p")).getText();
    }

    private void validateEmailFieldErrorMessage(final String firstExpectedErrorMessage, final String secondExpectedErrorMessage) {
        final var actualErrorMessage = findErrorMessageForEmailValidationFailure();
        var errorMessageAppeared = errorMessageAppeared(actualErrorMessage, firstExpectedErrorMessage, secondExpectedErrorMessage);
        assertThat(errorMessageAppeared, equalTo(true));
    }
    private boolean errorMessageAppeared(final String actualErrorMessage, final String firstExpectedErrorMessage, final String secondExpectedErrorMessage){
        return actualErrorMessage.equals(firstExpectedErrorMessage) || actualErrorMessage.equals(secondExpectedErrorMessage);
    }
    private void validatePasswordErrorMessage(final String expectedErrorMessage) {
        final var actualErrorMessage = findErrorMessageForPasswordValidationFailure();
        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));
    }
    public void waitForPageReadiness() {
        new WebDriverWait(factory.getWebDriver(), PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS).until(
                driver ->
                        String.valueOf(
                                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                        )
        );
    }

    public WebElement findInputField(WebDriver driver, String inputId, String secondaryId){
        try
        {
           var inputField = driver.findElement(By.xpath(String.format("//*[@id=%s]", inputId)));
           return inputField;
        }
        catch(NoSuchElementException e)
        {
            var inputField = driver.findElement(By.xpath(String.format("//*[@id=%s]", secondaryId)));
            return inputField;
        }
    }

}
