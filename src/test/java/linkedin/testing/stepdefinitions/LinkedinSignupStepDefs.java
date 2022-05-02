package linkedin.testing.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import linkedin.testing.pageobjects.FeedPage;
import linkedin.testing.pageobjects.Homepage;
import linkedin.testing.pageobjects.LoginPage;
import linkedin.testing.pageobjects.SignUpPage;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.security.Signature;
import java.time.Duration;

import static linkedin.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class LinkedinSignupStepDefs {

    @Autowired
    private Homepage homepage;

    @Autowired
    private SignUpPage signUpPage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private FeedPage feedPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened(){
        homepage.navigateToHomePage();
    }

    @And("the Regisztráció header button is clicked")
    public void theRegistrationHeaderButtonIsClicked(){ homepage.clickOnRegistrationButton();}

    @When("the Regisztráció button is clicked")
    public void theRegistrationButtonIsClicked() {
        signUpPage.clickOnRegistrationButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        System.out.println("Message:" +  message);
        System.out.println(signUpPage.getWebDriverFromFactory().findElement(By.cssSelector("div.inline-alert > p.artdeco-inline-feedback__message")).getText());

        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until( () -> signUpPage.getWebDriverFromFactory().findElement(By.cssSelector("div.inline-alert > p.artdeco-inline-feedback__message")).getText() == message);
    }

    @And("the Login header button is clicked")
    public void theLoginHeaderButtonIsClicked() {
        homepage.clickOnLoginButton();
    }

    @When("the User give Username and Password")
    public void userGiveUsernameAndPassword() {
        //Itt saját login adatot kell megadni
        //loginPage.setEmailInput("");
        //loginPage.setPasswordInput("");
    }

    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        loginPage.clickOnLoginButton();
    }

    @And("the Profil button is clicked")
    public void theProfilButtonIsClicked() {
        feedPage.clickOnProfilButton();
    }

    @Then("the User in Profil page")
    public void theUserInProfilPage() {
        Assert.assertEquals(true, feedPage.getWebDriverFromFactory().getCurrentUrl().matches("https://www.linkedin.com/in(.*)"));
    }
}
