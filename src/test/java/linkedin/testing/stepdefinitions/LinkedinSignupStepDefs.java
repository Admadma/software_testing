package linkedin.testing.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import linkedin.testing.pageobjects.HomePage;
import linkedin.testing.pageobjects.JoinNowPage;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static linkedin.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class LinkedinSignupStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private JoinNowPage joinNowPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened(){
        homePage.navigateToHomePage();
    }

    @And("the Join now header button is clicked")
    public void theRegistrationHeaderButtonIsClicked() {
        homePage.clickOnJoinNowButton();
    }

    @Given("it is scrolled down")
    public void itIsScrolledDown() {
        joinNowPage.scrollToTheBottomOfThePage();
    }

    @When("the Agree & Join button is clicked")
    public void theAgreeAndJoinButtonIsClicked(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        joinNowPage.clickOnAgreeAndJoinButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        System.out.println("-----------------------------------------");
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> joinNowPage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                                //By.xpath(String.format("//p[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))  //linkedin a hibeüzenetet egy <p> elemben írja ki, de így sem jó
                        ).size(),
                        Matchers.is(1));
    }

    @And("^the '(.*)' error message of the 'Email' should be shown$")
    public void theEmailErrorMessageShouldBeShown(final String message) {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        System.out.println("message: " + message);
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> joinNowPage.getWebDriverFromFactory().findElements(
                                //By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                                //By.xpath(String.format("//p[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))  //linkedin a hibeüzenetet egy <p> elemben írja ki, de így sem jó
                                By.xpath(String.format("//div[text()=\"%s\" or ./p[text()=\"%s\"]]", message, message))  //linkedin a hibeüzenetet egy <p> elemben írja ki, de így sem jó
                        ).size(),
                        Matchers.is(1));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        joinNowPage.getInputFieldByName(field).sendKeys(content);
    }

}
