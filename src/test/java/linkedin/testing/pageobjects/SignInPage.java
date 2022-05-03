package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SignInPage extends CommonPageObject{

    @FindBy(className = "btn__primary--large from__button--floating")
    private WebElement signInButton;

    @FindBy(id = "username")
    private WebElement emailOrPhone;

    @FindBy(id = "password")
    private WebElement passwordInput;

    public SignInPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnSignInButton(){
        waitForElementToBeClickable(signInButton);
        signInButton.click();
        waitForPageReadiness();
    }
}
