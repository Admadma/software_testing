package linkedin.testing.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import linkedin.testing.pageobjects.*;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    @Autowired
    private ProfilPage profilPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened(){
        homepage.navigateToHomePage();
    }


    @And("the Login header button is clicked")
    public void theLoginHeaderButtonIsClicked() {
        homepage.clickOnLoginButton();
    }

    @When("the User give Username and Password")
    public void userGiveUsernameAndPassword() {
        //Itt saját login adatot kell megadni
        loginPage.setEmailInput("zltnd97@gmail.com");
        loginPage.setPasswordInput("Szoftvertesztelés");
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

    @When("Go to logout page")
    public void goToLogoutPage() {
        feedPage.clickOnProfileDropdown();
        feedPage.clickOnLogoutDropdown();
    }

    @And("Click remember button")
    public void clickRememberButton() {
        feedPage.clickOnRememberButton();
    }

    @Then("the {string} message should be shown")
    public void theWelcomeBackMessageShouldBeShown(final String message) {
        String actualMessage = homepage.getWebDriverFromFactory().findElement(By.cssSelector("h1.header__content__heading")).getText();
        Assert.assertEquals(message,actualMessage);
    }

    @When("{string} is selected")
    public void languageIsSelected(final String message) {
        profilPage.scrollToTheBottomOfThePage();
        WebElement select = profilPage.getWebDriverFromFactory().findElement(By.id("globalfooter-select_language"));
        profilPage.waitForElementToBeClickable(select);
        Select drpLanguage = new Select(select);
        drpLanguage.selectByValue(message);

    }

    @Then("{string} , {string} and {string} field should be shown.")
    public void openToAddProfileSectionAndMoreFieldShouldBeShownInLanguage(final String message1, final String message2,final String message3) {
       Assert.assertEquals(message1 , profilPage.getOpenToButtonText());
       Assert.assertEquals(message2 , profilPage.getAddProfileButton());
       Assert.assertEquals(message3 , profilPage.getMoreButton());
    }

    @And("Page refreshed.")
    public void pageRefreshed() {
        profilPage.getWebDriverFromFactory().navigate().refresh();
    }
}
