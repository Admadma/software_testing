package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class FeedPage extends CommonPageObject{

    @FindBy(css = ".feed-identity-module__actor-meta > a.ember-view")
    private WebElement profilButton;

    @FindBy(css = ".global-nav__me > button.global-nav__primary-link")
    private WebElement profileDropdown;

    @FindBy(linkText = "Sign Out")
    private WebElement logoutButton;

    @FindBy(css = "button.full-width.artdeco-button.artdeco-button--2.artdeco-button--primary")
    private WebElement rememberButton;

    public FeedPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnProfilButton(){
        waitForElementToBeClickable(profilButton);
        profilButton.click();
        waitForPageReadiness();
    }

    public void clickOnProfileDropdown(){
        waitForElementToBeClickable(profileDropdown);
        profileDropdown.click();
        waitForPageReadiness();
    }

    public void clickOnLogoutDropdown(){
        waitForElementToBeClickable(logoutButton);
        logoutButton.click();
        waitForPageReadiness();
    }

    public void clickOnRememberButton(){
        waitForElementToBeClickable(rememberButton);
        rememberButton.click();
        waitForPageReadiness();
    }
}
