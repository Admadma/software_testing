package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignInPage extends CommonPageObject{

    @FindBy(className = "btn__primary--large")
    private WebElement signInButton;

    @FindBy(id = "username")
    private WebElement emailOrPhone;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Email or Phone", emailOrPhone,
            "Password", passwordInput
    );

    public SignInPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnSignInButton(){
        waitForElementToBeClickable(signInButton);
        signInButton.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}
