package linkedin.testing.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import linkedin.testing.pageobjects.HomePage;
import linkedin.testing.pageobjects.JoinNowPage;
import linkedin.testing.pageobjects.SignInPage;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;
import java.util.List;

import static linkedin.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@ContextConfiguration(classes = TestConfig.class)
public class LinkedinSignInStepDefs {

    @Autowired
    private HomePage homePage;

    @Autowired
    private SignInPage signInPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened(){
        homePage.navigateToHomePage();
    }

    @Given("the Sign in page is opened")
    public void theSignInPageIsOpened(){
        signInPage.navigateToSignInPage();
    }

    @Given("it is scrolled down")
    public void itIsScrolledDown() {
        signInPage.scrollToTheBottomOfThePage();
    }

    @And("the Sign in header button is clicked")
    public void theSignInHeaderButtonIsClicked(){
        homePage.clickOnSignInHeaderButton();
    }

    @When("the Sign in button is clicked")
    public void theSignInButtonIsClicked(){
        signInPage.clickOnSignInButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> signInPage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                        ).size(),
                        Matchers.is(1));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        signInPage.getInputFieldByName(field).sendKeys(content);
    }

}
