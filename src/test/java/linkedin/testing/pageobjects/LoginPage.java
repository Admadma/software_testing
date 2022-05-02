package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends CommonPageObject{

    @FindBy(css =".login__form_action_container > button")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;


    public LoginPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitForPageReadiness();
    }

    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }
    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }
}
