package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonPageObject{
    private static final String HOME_PAGE_URL = "https://www.linkedin.com/";

    @FindBy(className = "nav__button-tertiary")
    private WebElement registrationHeaderButton;

    @FindBy(className = "nav__button-secondary")
    private WebElement signInHeaderButton;

    public HomePage(WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage(){
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnJoinNowHeaderButton(){
        waitForElementToBeClickable(registrationHeaderButton);
        registrationHeaderButton.click();
        waitForPageReadiness();
    }

    public void clickOnSignInHeaderButton(){
        waitForElementToBeClickable(signInHeaderButton);
        signInHeaderButton.click();
        waitForPageReadiness();
    }

}
