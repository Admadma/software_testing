package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class Homepage extends CommonPageObject {

    private static final String HOME_PAGE_URL = "https://www.linkedin.com/home";

    @FindBy(css = "a.nav__button-tertiary")
    private WebElement registrationButton;

    @FindBy(css = "a.nav__button-secondary")
    private WebElement loginButton;

    public Homepage(WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage(){
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnRegistrationButton(){
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }

    public void clickOnLoginButton(){
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitForPageReadiness();
    }
}
