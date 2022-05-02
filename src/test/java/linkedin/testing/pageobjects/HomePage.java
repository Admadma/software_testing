package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonPageObject{
    private static final String HOME_PAGE_URL = "https://www.linkedin.com/";

    @FindBy(className = "nav__button-tertiary")
    private WebElement registrationButton;

    public HomePage(WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage(){
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnJoinNowButton(){
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }
}
